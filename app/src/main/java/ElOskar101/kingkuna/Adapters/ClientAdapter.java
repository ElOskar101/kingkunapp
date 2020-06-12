package ElOskar101.kingkuna.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import ElOskar101.kingkuna.Models.Client;
import ElOskar101.kingkuna.R;

public class ClientAdapter extends RecyclerView.Adapter<ClientAdapter.ViewHolder> {

    List<Client> clients;
    Activity activity;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView name, email, phone, address;
        private ImageView profile;

        public ViewHolder(@NonNull View v) {
            super(v);
           /* name = v.findViewById(R.id.name);
            email = v.findViewById(R.id.email);
            phone = v.findViewById(R.id.phone);
            address = v.findViewById(R.id.address);
            profile = v.findViewById(R.id.profile);*/
        }
    }


    public ClientAdapter(List<Client> clients, Activity activity) {
        this.activity = activity;
        this.clients = clients;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_clients, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        /*h.name.setText(contactsList.get(i).getName());
        h.email.setText(contactsList.get(i).getEmail());
        h.phone.setText(contactsList.get(i).getPhone());
        h.address.setText(contactsList.get(i).getAddress());
        Glide.with(activity).load(R.drawable.ic_user).into(h.profile);*/
    }


    @Override
    public int getItemCount() {
        return clients.size();
    }
}
