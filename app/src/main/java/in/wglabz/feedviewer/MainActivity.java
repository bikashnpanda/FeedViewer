package in.wglabz.feedviewer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        WebView cam1View =  findViewById(R.id.cam1);
        WebView cam2View =  findViewById(R.id.cam2);

        cam1View.setWebViewClient(new MyBrowser());
        cam1View.getSettings().setLoadsImagesAutomatically(true);
        cam1View.getSettings().setJavaScriptEnabled(true);
        cam1View.loadUrl("http://192.168.0.101:8765/picture/1/frame/");

        cam2View.setWebViewClient(new MyBrowser());
        cam2View.getSettings().setLoadsImagesAutomatically(true);
        cam2View.getSettings().setJavaScriptEnabled(true);
        cam2View.loadUrl("http://192.168.0.101:8765/picture/2/frame/");

    }

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
