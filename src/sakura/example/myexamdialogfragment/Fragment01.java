
package sakura.example.myexamdialogfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class Fragment01 extends Fragment implements OnClickListener, DialogListener {
    // DialogListenerを実装しておく

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }
        return inflater.inflate(R.layout.fragment01, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Button button = (Button) getView().findViewById(R.id.button1);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                // 以前ゴチャゴチャやってたけどもっとシンプルに書けました。考慮不足で申し訳ありません！
                CommonDialogFragment newFragment = CommonDialogFragment.newInstance(
                        "title", "this is message");
                newFragment.setDialogListener(this);
                newFragment.show(getActivity().getSupportFragmentManager(), "CommonDialogFragment");

                break;

            default:
                break;
        }
    }

    @Override
    public void onPositiveClick() {
        Toast.makeText(getActivity(), "ok ボタンが押された", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNegativeClick() {
        Toast.makeText(getActivity(), "cancel ボタンが押された", Toast.LENGTH_SHORT).show();
    }

}
