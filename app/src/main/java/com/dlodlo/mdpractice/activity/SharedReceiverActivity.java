package com.dlodlo.mdpractice.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.dlodlo.mdpractice.R;
import com.dlodlo.widget.linkpreview.LinkPreviewCallback;
import com.dlodlo.widget.linkpreview.SourceContent;
import com.dlodlo.widget.linkpreview.TextCrawler;


public class SharedReceiverActivity extends AppCompatActivity {

    private ListView shareListView;
    private String mTitle;
    private boolean mIsPlainNormalText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        TextCrawler textCrawler = new TextCrawler();
//        textCrawler.makePreview(callback, "https://www.baidu.com/");
        setContentView(R.layout.activity_share_receiver);
        initView();

        HtmlFrom.getPageAsyc("https://www.taobao.com/");

    }
    TextView content;

    TextView from;

    ImageView image;


    private void initView() {


        Button ok = (Button) findViewById(R.id.share_ok);
        Button cancel = (Button)findViewById(R.id.share_cancel);
        content = (TextView) findViewById(R.id.share_cotent);
        from = (TextView) findViewById(R.id.share_from);
        image = (ImageView) findViewById(R.id.share_image);
        TextView title = (TextView) findViewById(R.id.share_title);

    }


    private String imageString;

    private String fromString;

    private String description;

    private String titleString;

    private String finalUri;

    /** Callback to update your view. Totally customizable. */
    /** onPre() will be called before the crawling. onPos() after. */
    /**
     * You can customize this to update your view
     */
    private LinkPreviewCallback callback = new LinkPreviewCallback() {

        @Override
        public void onPre() {
        }

        @Override
        public void onPos(SourceContent sourceContent, boolean isNull) {
            if (sourceContent != null) {
                Log.e("share", sourceContent.getImages().size() + "");
                Log.e("share", sourceContent.getCannonicalUrl());
                Log.e("share", sourceContent.getDescription());
                Log.e("share", sourceContent.getFinalUrl());
                Log.e("share", sourceContent.getTitle());

                if (sourceContent.getImages().size() > 0) {
                    imageString = sourceContent.getImages().get(0);
                }
//                Log.e("share", imageString);

                fromString = sourceContent.getCannonicalUrl();
                description = sourceContent.getDescription();
                titleString = sourceContent.getTitle();
                finalUri = sourceContent.getFinalUrl();

                from.setText(fromString + ">>> " + imageString);
                content.setText(description);

            }
        }
    };

}
