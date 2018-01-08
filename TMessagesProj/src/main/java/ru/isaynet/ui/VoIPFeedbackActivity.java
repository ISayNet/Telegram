package ru.isaynet.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import ru.isaynet.messenger.AndroidUtilities;
import ru.isaynet.messenger.LocaleController;
import ru.isaynet.messenger.MessagesController;
import ru.isaynet.messenger.R;
import ru.isaynet.tgnet.ConnectionsManager;
import ru.isaynet.tgnet.RequestDelegate;
import ru.isaynet.tgnet.TLObject;
import ru.isaynet.tgnet.TLRPC;
import ru.isaynet.ui.ActionBar.AlertDialog;
import ru.isaynet.ui.ActionBar.Theme;
import ru.isaynet.ui.Components.BetterRatingView;
import ru.isaynet.ui.Components.LayoutHelper;
import ru.isaynet.ui.Components.voip.VoIPHelper;

public class VoIPFeedbackActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
		super.onCreate(savedInstanceState);

		overridePendingTransition(0, 0);

		setContentView(new View(this));

		VoIPHelper.showRateAlert(this, new Runnable(){
			@Override
			public void run(){
				finish();
			}
		}, getIntent().getLongExtra("call_id", 0), getIntent().getLongExtra("call_access_hash", 0));
	}

	@Override
	public void finish() {
		super.finish();
		overridePendingTransition(0, 0);
	}
}
