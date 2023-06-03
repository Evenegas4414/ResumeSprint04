package com.ervr.resume;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {
    private Context context;
    private List<ContactItem> contactItemList;


    public ContactAdapter(Context context, List<ContactItem> contactItemList) {
        this.context = context;
        this.contactItemList = contactItemList;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        final ContactItem contactItem = contactItemList.get(position);
        holder.bind(contactItem);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openContactApp(contactItem.getName());
            }
        });
    }

    private void openContactApp(String contactName) {
        Intent intent;

        switch (contactName) {
            case "Teléfono":
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:912345678"));
                break;
            case "LinkedIn":
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://linkedin.com/"));
                break;
            case "Twitter":
                intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("https://twiiter.com/"));
                break;
            default:
                return;
        }

        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
        }
    }


    @Override
    public int getItemCount() {
        return contactItemList.size();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder {
        private ImageView iconImageView;
        private TextView nameTextView;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            iconImageView = itemView.findViewById(R.id.iconImageView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
        }

        public void bind(ContactItem contactItem) {
            iconImageView.setImageResource(contactItem.getIcon());
            nameTextView.setText(contactItem.getName());
        }
    }
}
