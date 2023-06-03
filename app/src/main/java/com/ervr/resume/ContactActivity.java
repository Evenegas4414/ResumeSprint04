package com.ervr.resume;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ContactActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ContactAdapter contactAdapter;
    private List<ContactItem> contactItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        recyclerView = findViewById(R.id.contactRecyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Crear la lista de elementos de la lista (ContactItem) y agregarlos a la lista
        contactItemList = new ArrayList<>();
        contactItemList.add(new ContactItem("Teléfono", R.drawable.baseline_phone_24));
        contactItemList.add(new ContactItem("LinkedIn", R.drawable.linkedin));
        contactItemList.add(new ContactItem("Twitter", R.drawable.twitter));

        contactAdapter = new ContactAdapter(this, contactItemList);

        recyclerView.setAdapter(contactAdapter);

        FrameLayout messageContainer = findViewById(R.id.messageContainer);
        MessageFragment messageFragment = new MessageFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(messageContainer.getId(), messageFragment)
                .commit();
    }
}
