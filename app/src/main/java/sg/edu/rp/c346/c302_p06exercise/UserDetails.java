package sg.edu.rp.c346.c302_p06exercise;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class UserDetails extends AppCompatActivity {
    TextView tvName, tvUsername, tvEmail, tvAddress, tvPhone, tvWebsite, tvCompany;
    Address address;
    Geo geo;
    Company company;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        tvName = (TextView)findViewById(R.id.textViewName);
        tvUsername = (TextView)findViewById(R.id.textViewUsername);
        tvEmail = (TextView)findViewById(R.id.textViewEmail);
        tvAddress = (TextView)findViewById(R.id.textViewAddress);
        tvPhone = (TextView)findViewById(R.id.textViewPhone);
        tvWebsite = (TextView)findViewById(R.id.textViewWebsite);
        tvCompany =(TextView)findViewById(R.id.textViewCompany);

        Intent intentReceived = getIntent();
        int id = intentReceived.getIntExtra("user_id", 0);
        String name = intentReceived.getStringExtra("name");
        String userName = intentReceived.getStringExtra("userName");
        String email = intentReceived.getStringExtra("email");
        address = (Address) intentReceived.getSerializableExtra("address");
        String street = address.getStreet();
        String suite = address.getSuite();
        String city = address.getCity();
        String zipcode = address.getZipcode();
        geo = address.getGeo();
        String lat = geo.getLat();
        String lng = geo.getLng();
        String phone = intentReceived.getStringExtra("phone");
        String website = intentReceived.getStringExtra("website");
        company = (Company) intentReceived.getSerializableExtra("company");
        String companyName = company.getName();
        String catchPhrase = company.getCatchPhrase();
        String bs = company.getBs();

        tvName.setText("Name: " + name + "\n");
        tvUsername.setText("Username: " + userName + "\n");
        tvEmail.setText("Email: " + email + "\n");
        tvAddress.setText("Address: " + street + " " + suite + " " + city + ", " + zipcode + "\n\nLat: " + lat + "\n\nLng: " + lng + "\n");
        tvPhone.setText("Phone: " + phone + "\n");
        tvWebsite.setText("Website: " + website + "\n");
        tvCompany.setText("Company: " + companyName + "\n\nCatchPhrase: " + catchPhrase + "\n\nBS: " + bs + "\n");
    }
}
