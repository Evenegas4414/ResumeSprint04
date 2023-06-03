package com.ervr.resume;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class MessageFragment extends Fragment {

    private EditText messageEditText;
    private Button sendButton;

    public MessageFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_message, container, false);

        messageEditText = view.findViewById(R.id.messageEditText);
        sendButton = view.findViewById(R.id.sendButton);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = messageEditText.getText().toString();
                sendMessage(message);
            }
        });

        return view;
    }

    private void sendMessage(String message) {
        // Simular el envío del mensaje
        Toast.makeText(getActivity(), "Mensaje enviado: " + message, Toast.LENGTH_SHORT).show();
    }
}
