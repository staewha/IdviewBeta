package com.example.idviewbeta


import android.content.Context
import android.content.res.AssetManager
import android.graphics.Bitmap
import android.graphics.Canvas
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.googlecode.tesseract.android.TessBaseAPI
import com.example.idviewbeta.ConnectCiActivity
import java.io.*

class WebGoogleActivity : AppCompatActivity() {
    lateinit var dataPath : String
    lateinit var tessBaseAPI: TessBaseAPI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_google)

        val googleWebView = findViewById<WebView>(R.id.web_view_google)
        googleWebView.settings.apply {
            javaScriptEnabled = true
            domStorageEnabled = true
            setSupportMultipleWindows(true)
            cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK
        }
        googleWebView.apply {
            webViewClient = WebViewClient()
            loadUrl("https://myaccount.google.com/permissions?continue=https%3A%2F%2Fmyaccount.google.com%2Fdata-and-privacy")
        }


        val context : Context = applicationContext
        val path = context.filesDir
        Log.v("path", path.toString())
        val korPath = context.getFileStreamPath("kor.traineddata")
        Log.v("path", korPath.toString())

        tessBaseAPI = TessBaseAPI()
        dataPath = File(context.filesDir, "tesseract").absolutePath

        checkFile(File("$dataPath/tessdata/"), "kor")
        checkFile(File("$dataPath/tessdata/"), "eng")

        val lang : String = "kor+eng"
        tessBaseAPI.init(dataPath, lang)


        val floatingBtnGoogle = findViewById<FloatingActionButton>(R.id.floatBtnGoogle)

        floatingBtnGoogle.setOnClickListener {
            Log.v("floatBtn", "Click listener of floatting action button")
            var top = 0
            val contentHeight = googleWebView.contentHeight
            var ocrResult = ""
            Thread {
                while (!ocrResult.contains("Privacy")) {
                    val captureBitmap = capture()
                    ocrResult = processImage(captureBitmap)
                    top += googleWebView.height
                    googleWebView.scrollTo(0, top)
                }
                Log.v("finishOCR", "Finish OCR!!!")
            }.start()
        }
    }

    fun capture() : Bitmap{
        val captureView = window.decorView.rootView
        val bitmap = Bitmap.createBitmap(captureView.width, captureView.height, Bitmap.Config.ARGB_8888)

        if (bitmap == null) {
            Log.v("capture_function", "Bitmap is null!!")
        } else {
            Log.v("capture_function", "Bitmap is not null!!")
            val canvas = Canvas(bitmap)
            captureView.draw(canvas)
        }

        return bitmap
    }

    fun processImage(bitmap: Bitmap) : String {
//        Toast.makeText(applicationContext, "잠시 기다려주세요.", Toast.LENGTH_SHORT).show()
        var ocrResult : String? = null
        tessBaseAPI.setImage(bitmap)
        ocrResult = tessBaseAPI.utF8Text
        Log.v("ocrResult", ocrResult)
        return ocrResult
    }

    /***
     *  언어 데이터 파일을 기기에 복사하는 기능
     *  @param lang: 언어 데이터 종류
     */
    private fun copyFile(lang: String) {
        try {
            //언어데이타파일의 위치
            val filePath: String = "$dataPath/tessdata/$lang.traineddata"

            //AssetManager를 사용하기 위한 객체 생성
            val assetManager: AssetManager = assets;

            //byte 스트림을 읽기 쓰기용으로 열기
            val inputStream: InputStream = assetManager.open("tessdata/$lang.traineddata")
            val outStream: OutputStream = FileOutputStream(filePath)


            //위에 적어둔 파일 경로쪽으로 해당 바이트코드 파일을 복사한다.
            val buffer = ByteArray(1024)

            var read: Int = 0
            read = inputStream.read(buffer)
            while (read != -1) {
                outStream.write(buffer, 0, read)
                read = inputStream.read(buffer)
            }
            outStream.flush()
            outStream.close()
            inputStream.close()

        } catch (e: FileNotFoundException) {
            Log.v("오류발생", e.toString())
        } catch (e: IOException) {
            Log.v("오류발생", e.toString())
        }

    }

    private fun checkFile(dir : File, lang : String){

        //파일의 존재여부 확인 후 내부로 복사
        if(!dir.exists()&&dir.mkdirs()){
            Log.v("Check File", "$lang doesn't exist!")
            copyFile(lang)
        }

        if(dir.exists()){
            val datafilePath : String = "$dataPath/tessdata/$lang.traineddata"
            val dataFile : File = File(datafilePath)
            if(!dataFile.exists()){
                copyFile(lang)
            }
        }

    }

}