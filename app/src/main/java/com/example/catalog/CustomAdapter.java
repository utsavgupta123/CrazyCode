package com.example.catalog;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private items[] localDataSet;
    private  int[] ct;
    private  int cost;
    private Context context;
    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;
        private final Button button;
        private final ImageView imageview;

        public ViewHolder(View view) {

            super(view);
            textView = (TextView) view.findViewById(R.id.textView);
            button=(Button)view.findViewById(R.id.button);
            imageview=(ImageView)view.findViewById(R.id.imageview);
            // Define click listener for the ViewHolder's View

                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String p=button.getText().toString();
                           cost=cost+Integer.parseInt(p);
                            Toast.makeText(view.getContext(), Integer.toString(cost), Toast.LENGTH_SHORT).show();
//
                        }
                    });




        }

        public TextView getTextView() {
            return textView;
        }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView.
     */
    public CustomAdapter(items[] dataSet,int[] p) {
        localDataSet = dataSet;
        ct=p;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.text_row_item, viewGroup, false);
        ViewHolder vh=new ViewHolder(view);
        context= viewGroup.getContext();

        return vh;
    }

//    @NonNull
//    @org.jetbrains.annotations.NotNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
//        return null;
//    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element



        viewHolder.getTextView().setText(localDataSet[position].name);
        viewHolder.button.setText(Integer.toString(localDataSet[position].price));
       // viewHolder.imageview.getDrawable(R.drawable.ic_launcher_background);
    }



    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.length;
    }
}