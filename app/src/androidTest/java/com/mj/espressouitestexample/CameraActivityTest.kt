//package com.mj.espressouitestexample
//
//import android.app.Instrumentation
//import android.graphics.BitmapFactory
//import androidx.test.espresso.intent.rule.IntentsTestRule
//import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
//import org.junit.Assert.*
//import org.junit.Rule
//import org.junit.runner.RunWith
//
//@RunWith(AndroidJUnit4ClassRunner::class)
//class CameraActivityTest {
//
//    @get: Rule
//    val intentsTestRule = IntentsTestRule(CameraActivity::class.java)
//
//    @Test
//    fun test_cameraIntent_isBitmapSetToImage() {
//
//        // given
//        val activityResult = createImageCaptureActivityResultStub()
//    }
//
//
//    private fun createImageCaptureActivityResultStub(): ActivityResult? {
//        val bundle = Bundle()
//        bundle.putParcelable(
//            KEY_IMAGE_DATA,
//            BitmapFactory.decodeResource(
//                instru
//            )
//        )
//    }
//}