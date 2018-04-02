package cz.hanusova.coderecognition.start;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import cz.hanusova.coderecognition.R;
import cz.hanusova.coderecognition.reader.ReaderActivity;
import cz.hanusova.coderecognition.util.Constants;
import dagger.android.AndroidInjection;

/**
 * Created by KHanusova on 24.03.2018.
 */

public class StartActivity extends AppCompatActivity implements StartActivityView {

    @Inject
    StartActivityPresenter presenter;

    @BindView(R.id.scanned_text)
    EditText scannedText;
    @BindView(R.id.start_scan)
    Button startScan;

    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity);
        AndroidInjection.inject(this);
        unbinder = ButterKnife.bind(this);
        changeText("Activity start");
    }

    @Override
    protected void onDestroy() {
        if (unbinder != null) {
            unbinder.unbind();
        }
        super.onDestroy();
    }

    @OnClick(R.id.start_scan)
    void startScan() {
        Intent intent = new Intent(this, ReaderActivity.class);
        startActivityForResult(intent, Constants.REQ_READER);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == Constants.REQ_READER && resultCode == Activity.RESULT_OK) {
            String result = data.getStringExtra(Constants.EXTRA_TEXT);
            changeText(result);
            //TODO: display result and send it to presenter
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void changeText(String text) {
        scannedText.setText(text);
    }
}
