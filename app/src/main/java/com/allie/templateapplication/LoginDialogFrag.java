package com.allie.templateapplication;

import android.app.DialogFragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class LoginDialogFrag extends DialogFragment {

    private SharedPreferences mSharedPreferences;
    public static final String PREFS_FILE = "MyPrefsFile";

    static LoginDialogFrag newInstance() {
        return new LoginDialogFrag();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_login, container, false);


        mSharedPreferences = getActivity().getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE);

        getDialog().setCanceledOnTouchOutside(false);
        Button mLoginButton = (Button) v.findViewById(R.id.LoginButton);
        EditText password = (EditText) v.findViewById(R.id.pass_login);
        EditText email = (EditText) v.findViewById(R.id.email_login);

        if (mSharedPreferences.getAll().containsKey("email") && mSharedPreferences.getAll().containsKey("pass")) {
            mLoginButton.setText(R.string.login);

            mLoginButton.setOnClickListener(view -> {

                onDestroyView();
            });
        } else {
            mLoginButton.setText(R.string.register);

            mLoginButton.setOnClickListener(view -> {
                mSharedPreferences.edit().putString("email", email.getText().toString()).apply();
                mSharedPreferences.edit().putString("pass", password.getText().toString()).apply();

                onDestroyView();

            });
        }

        return v;
    }

}
