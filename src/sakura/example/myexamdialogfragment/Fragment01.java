
package sakura.example.myexamdialogfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
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
                // バックスタックに以前のFragmentがあれば取り除く
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                Fragment prev = getFragmentManager().findFragmentByTag("CommonDialogFragment");
                if (prev != null) {
                    ft.remove(prev);
                }
                ft.addToBackStack(null);

                // Create and show the dialog.
                CommonDialogFragment newFragment = CommonDialogFragment.newInstance(
                        "title", "this is message");
                newFragment.setDialogListener(this);
                newFragment.show(ft, "CommonDialogFragment");

                if (newFragment.isVisible()) {
                    newFragment.dismiss();
                }

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
