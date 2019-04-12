package com.peter.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.peter.R;

public class BsRegistration extends AppCompatActivity {
    WebView bsRegistrationWebView;
    ProgressBar bsRegistrationProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bs_registration);

        bsRegistrationProgress = findViewById(R.id.bs_registration_progress);
        bsRegistrationWebView = (WebView) findViewById(R.id.bs_registration_web_view);

        WebSettings settings = bsRegistrationWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        bsRegistrationWebView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);


        bsRegistrationProgress.setVisibility(View.VISIBLE);

        bsRegistrationWebView.setWebViewClient(new WebViewClient() {
                                                   @Override
                                                   public void onPageFinished(WebView view, String url) {
                                                       if (bsRegistrationProgress.isShown()) {
                           bsRegistrationProgress.setVisibility(View.GONE);
                                                       }
                                                   }

                                                   @Override
                                                   public void onReceivedError(WebView view,  WebResourceRequest request, WebResourceError error) {
                                                       AlertDialog.Builder builder = new AlertDialog.Builder(BsRegistration.this);
                                                       builder.setTitle("Sorry An Error Occurred");
                                                       builder.setIcon(R.drawable.theme_verse);
                                                       builder.setMessage(error.toString()+". \nPlease check your network Connectivity.");
                                                       builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                           @Override
                                                           public void onClick(DialogInterface dialog, int which) {
                                                               recreate();
                                                           }
                                                       });
                                                       AlertDialog dialog = builder.create();
                                                       dialog.show();
                                                   }
                                               }


        );


        bsRegistrationWebView.loadUrl("https://goo.gl/forms/ZUwIHCMEFqGed2ys1");
        //        https://goo.gl/forms/ZUwIHCMEFqGed2ys1

    }


}
