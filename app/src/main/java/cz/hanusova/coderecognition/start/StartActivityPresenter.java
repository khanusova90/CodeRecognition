package cz.hanusova.coderecognition.start;

import cz.hanusova.coderecognition.base.BasePresenter;

/**
 * Created by KHanusova on 24.03.2018.
 */

public class StartActivityPresenter implements BasePresenter<StartActivityView>{
    private StartActivityView view;

    @Override
    public void onAttach(StartActivityView view) {
        this.view = view;
    }

    @Override
    public void onDetach() {
        this.view = null;
    }

    public void recognizeCodes(){
        //TODO: tady pridej algoritmy pro rozpoznavani sifer. Potom to muzeme refactorovat :)
    }
}
