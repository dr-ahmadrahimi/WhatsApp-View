package dr.rahimi.ahmad.whatsapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class WhatsApp_MyChats extends RecyclerView.Adapter<WhatsApp_MyChats.MyHolder> {

    Context context;
    List<WhatsApp_Chats> WhatsApp_list;
    int WhatsApp_type;

    public WhatsApp_MyChats(Context context, List<WhatsApp_Chats> list) {
        this.context = context;
        this.WhatsApp_list = list;
    }



    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.whats_app_list_item,parent,false);
        return new MyHolder(view1);

    }




    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.WhatsApp_time.setText(WhatsApp_list.get(position).getWhatsApp_time());
        holder.WhatsApp_seen.setImageResource(WhatsApp_list.get(position).getWhatsApp_seen());
        holder.WhatsApp_text.setText(WhatsApp_list.get(position).getWhatsApp_text());
        WhatsApp_type = WhatsApp_list.get(position).getWhatsApp_type();


        if (WhatsApp_type == 1) {
            holder.WhatsApp_card.setCardBackgroundColor(Color.rgb(195,255,145));
            holder.WhatsApp_Layout_text.setGravity(View.FOCUS_RIGHT);

        } else {
            holder.WhatsApp_card.setCardBackgroundColor(Color.rgb(255,255,255));
            holder.WhatsApp_seen.setVisibility(View.GONE);
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) holder.WhatsApp_Layout_text.getLayoutParams();
            p.setMargins(0, 0, 150, 0);
//                WhatsApp_Layout_text.requestLayout();
            holder.WhatsApp_Layout_text.setGravity(View.FOCUS_LEFT);

        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {

                Toast.makeText(context, "POS : " + position + "\n" + WhatsApp_type, Toast.LENGTH_SHORT).show();

            }
        });

    }





    @Override
    public int getItemCount() {
        return WhatsApp_list.size();
    }


    public class MyHolder extends RecyclerView.ViewHolder {
        TextView WhatsApp_time;
        ImageView WhatsApp_seen;
        TextView WhatsApp_text;
        CardView WhatsApp_card;
        LinearLayout WhatsApp_Layout_text;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            WhatsApp_time = itemView.findViewById(R.id.TXT_WhatsApp_time);
            WhatsApp_seen = itemView.findViewById(R.id.IMG_WhatsApp_seen);
            WhatsApp_text = itemView.findViewById(R.id.TXT_WhatsApp_text);

            WhatsApp_card = itemView.findViewById(R.id.Card_WhatsApp_content);
            WhatsApp_Layout_text = itemView.findViewById(R.id.Layout_WhatsApp_text);

        }
    }

}
