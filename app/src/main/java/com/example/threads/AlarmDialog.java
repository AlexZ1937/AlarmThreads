package com.example.threads;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class AlarmDialog extends DialogFragment {
    @NonNull
    public Dialog onCreateDialog(Bundle savedInst)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        return
//                builder.setView(R.layout.activity_main)
//                        .setTitle("Test title")
//                        .setMessage("This is same test...")
//                        .setIcon(R.drawable.ic_launcher_background)
//                        .setPositiveButton("+", null)
//                        .setNegativeButton("-", null)
//                        .create();
                builder.setTitle("Tittle!")
                        .setMessage("Alarm!!...")
                        .setIcon(R.drawable.ic_launcher_background)
                        .setNeutralButton("OK", null)
                        .create();

    }
}
