package sg.edu.rp.c346.c302_p06exercise;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 15017103 on 30/5/2017.
 */

public class UserAdapter extends ArrayAdapter<User> {
    Context context;
    int layoutResourceId;
    ArrayList<User> UserList = null;

    public UserAdapter(Context context, int layoutResourceId, ArrayList<User> categoryList) {
        super(context, layoutResourceId, categoryList);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.UserList = categoryList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        CategoryHolder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new CategoryHolder();
            holder.txtName = (TextView)row.findViewById(R.id.textViewName);
            holder.txtUserName = (TextView)row.findViewById(R.id.textViewUsername);
            holder.txtEmail = (TextView)row.findViewById(R.id.textViewEmail);
            holder.txtAddress = (TextView)row.findViewById(R.id.textViewAddress);
            holder.txtPhone = (TextView)row.findViewById(R.id.textViewPhone);
            holder.txtWebsite = (TextView)row.findViewById(R.id.textViewWebsite);
            holder.txtCompany = (TextView)row.findViewById(R.id.textViewCompany);
            row.setTag(holder);
        }
        else
        {
            holder = (CategoryHolder)row.getTag();
        }

        User user = UserList.get(position);
        holder.txtName.setText("Name: " + user.getName());
//        holder.txtUserName.setText("Username: " + user.getUsername());
//        holder.txtEmail.setText("Email: " + user.getEmail());
//        String street = user.getAddress().getStreet();
//        String suite = user.getAddress().getSuite();
//        String city = user.getAddress().getCity();
//        String zipcode = user.getAddress().getZipcode();
//        Geo geo = user.getAddress().getGeo();
//        String lat = geo.getLat();
//        String lng = geo.getLng();
//        holder.txtAddress.setText("Address: " + street + " " + suite + " " + city + ", " + zipcode + "\nLat: " + lat + "\nLng: " + lng );
//        holder.txtPhone.setText("Phone: " + user.getPhone());
//        holder.txtWebsite.setText("Website: " + user.getWebsite());
//        Company company = user.getCompany();
//        String name = company.getName();
//        String catchPhrase = company.getCatchPhrase();
//        String bs = company.getBs();
//        holder.txtCompany.setText("Name: " + name + "\nCatchPhrase: " + catchPhrase + "\nBS: " + bs);
        return row;
    }

    static class CategoryHolder
    {
        TextView txtName, txtEmail, txtUserName, txtAddress, txtPhone, txtWebsite, txtCompany;
    }
}

