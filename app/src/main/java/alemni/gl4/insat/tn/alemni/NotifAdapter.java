package alemni.gl4.insat.tn.alemni;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import alemni.gl4.insat.tn.alemni.model.NotificationE;

/**
 * Created by Lenovo on 09/05/2017.
 */

public class NotifAdapter extends RecyclerView.Adapter<NotifAdapter.MyViewHolder> {


    private List<NotificationE> moviesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;


        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);


        }
    }


    public NotifAdapter(List<NotificationE> moviesList)
    {
        this.moviesList = moviesList;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.notif_list_row, parent, false);

        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        NotificationE movie = moviesList.get(position);
        holder.title.setText(movie.getDes());

    }



    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}