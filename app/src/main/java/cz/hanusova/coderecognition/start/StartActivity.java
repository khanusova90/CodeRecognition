package cz.hanusova.coderecognition.start;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cz.hanusova.coderecognition.R;
import dagger.android.AndroidInjection;

/**
 * Created by KHanusova on 24.03.2018.
 */

public class StartActivity extends AppCompatActivity implements StartActivityView {

    @Inject
    StartActivityPresenter presenter;

    @BindView(R.id.scanned_text)
    EditText scannedText;

    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity);
        AndroidInjection.inject(this);
        unbinder = ButterKnife.bind(this);
        changeText();
    }

    @Override
    protected void onDestroy() {
        if (unbinder != null) {
            unbinder.unbind();
        }
        super.onDestroy();
    }

    private void changeText(){
        scannedText.setText(presenter.getText());
    }
}
