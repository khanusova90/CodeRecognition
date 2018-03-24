package cz.hanusova.coderecognition.base;

/**
 * Created by KHanusova on 24.03.2018.
 */

public interface BasePresenter<V extends BaseView> {
    void onAttach(V view);

    void onDetach();
}
