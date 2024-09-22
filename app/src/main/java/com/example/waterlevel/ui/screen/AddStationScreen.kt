package com.example.waterlevel.ui.screen

import android.util.Log
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageAnalysis
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import com.example.waterlevel.ui.component.BarcodeAnalyzer
import com.example.waterlevel.ui.theme.WaterLevelTheme
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun AddStationScreen(onBarcodeScanner: (String) -> Unit){
    val cameraPermissionState = rememberPermissionState(android.Manifest.permission.CAMERA)

    if (cameraPermissionState.status.isGranted) {
        AddStationDetails(onBarcodeScanner)
    } else if (cameraPermissionState.status.shouldShowRationale) {
        Text("Camera Permission permanently denied")
    } else {
        SideEffect {
            cameraPermissionState.run { launchPermissionRequest() }
        }
        Text("No Camera Permission")
    }
}

@Composable
fun AddStationDetails(onBarcodeScanner: (String) -> Unit) {
    val localContext = LocalContext.current
    val lifecycleOwner = androidx.lifecycle.compose.LocalLifecycleOwner.current
    val cameraProviderFuture = remember {
        ProcessCameraProvider.getInstance(localContext)
    }
    Column (
        modifier = Modifier.padding(100.dp)
    ){
        AndroidView(
            modifier = Modifier.fillMaxSize(),
            factory = { context ->
                val previewView = PreviewView(context)
                val preview = androidx.camera.core.Preview.Builder().build()
                val selector = CameraSelector.Builder()
                    .requireLensFacing(CameraSelector.LENS_FACING_BACK)
                    .build()

                preview.setSurfaceProvider(previewView.surfaceProvider)

                val imageAnalysis = ImageAnalysis.Builder().build()
                imageAnalysis.setAnalyzer(
                    ContextCompat.getMainExecutor(context),
                        BarcodeAnalyzer(onBarcodeScanner)
                )

                runCatching {
                    cameraProviderFuture.get().bindToLifecycle(
                        lifecycleOwner,
                        selector,
                        preview,
                        imageAnalysis
                    )
                }.onFailure {
                    Log.e("CAMERA", "Camera bind error ${it.localizedMessage}", it)
                }
                previewView
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AddStationPreview() {
    WaterLevelTheme {
        AddStationDetails(onBarcodeScanner = {})
    }
}