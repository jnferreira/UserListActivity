package countrylist.estg.ipp.pt.userlistactivity;

import android.content.Context;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by NunoFerreira on 31/10/17.
 */

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {

    private Context mContext;
    private List<Contact> mContacts;



    public ContactsAdapter(Context context, List<Contact> contacts){
        mContacts = contacts;
        mContext = context;
    }

    private Context getContext(){
        return mContext;
    }

    @Override
    public ContactsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);


        View contactView = inflater.inflate(R.layout.layout_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ContactsAdapter.ViewHolder viewHolder, int position) {

        Contact contact = mContacts.get(position);

        TextView textView = viewHolder.nameTextView;
        textView.setText(contact.getName());

        Button button = viewHolder.messageButton;
        button.setText(contact.isOnline() ? "Message" : "OffLine");
        button.setEnabled(contact.isOnline());

        if (contact.isOnline()){
            viewHolder.imageView.setImageDrawable();
        }else{
            viewHolder.imageView.setImageDrawable();
        }

    }

    @Override
    public int getItemCount() {
        return mContacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView nameTextView;
        public Button messageButton;

        public ViewHolder(View itemView){
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.onlineImage);
            nameTextView = (TextView) itemView.findViewById(R.id.contact_name);
            messageButton = (Button) itemView.findViewById(R.id.message_button);
            messageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();

                    Contact contact = mContacts.get(position);

                    Intent intent = new Intent(mContext, ContactActivity.class);
                    intent.putExtra("contact_name", contact.getName());
                    mContext.startActivity(intent);
                }
            });
        }


    }
}
