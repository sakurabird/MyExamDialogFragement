
package sakura.example.myexamdialogfragment;

import java.util.EventListener;

public interface DialogListener extends EventListener {

    /**
     * okボタンが押されたイベントを通知する
     */
    public void onPositiveClick();

    /**
     * cancelボタンが押されたイベントを通知する
     */
    public void onNegativeClick();
}
