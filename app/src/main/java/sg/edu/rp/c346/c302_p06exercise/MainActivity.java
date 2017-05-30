package sg.edu.rp.c346.c302_p06exercise;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonWriter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listViewUser;
    ArrayList<User> userList = new ArrayList<User>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String url = "http://trytocode.com/c302/users.json";
        HttpRequest request = new HttpRequest(url);
        request.setMethod("GET");
        request.execute();

        try {
            //TODO 4
            String jsonString = request.getResponse();

//            String jsonString = "[{\"category_id\":\"1\",\"name\":\"Sports\",\"description\":\"Sports photos\"}," +
//                    "{\"category_id\":\"2\",\"name\":\"Family\",\"description\":\"Family photos\"}]";
            System.out.println(">>" + jsonString);
            JSONArray jsonArray = new JSONArray(jsonString);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObj = jsonArray.getJSONObject(i);
                User user = new User();
                user.setId(Integer.parseInt(jsonObj.getString("id")));
                user.setName(jsonObj.getString("name"));
                user.setUsername(jsonObj.getString("username"));
                user.setEmail(jsonObj.getString("email"));
                JSONObject addressObj = (JSONObject) jsonObj.get("address");
                JSONObject geoObj = (JSONObject) addressObj.get("geo");
                JSONObject companyObj = (JSONObject) jsonObj.get("company");
                Geo geo = new Geo(geoObj.getString("lat"), geoObj.getString("lng"));
                Address address = new Address(addressObj.getString("street"), addressObj.getString("suite"), addressObj.getString("city"),addressObj.getString("zipcode"), geo);
                Company company = new Company(companyObj.getString("name"), companyObj.getString("catchPhrase"),companyObj.getString("bs"));
                user.setAddress(address);
                user.setPhone(jsonObj.getString("phone"));
                user.setWebsite(jsonObj.getString("website"));
                user.setCompany(company);
                userList.add(user);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }

        UserAdapter adapter = new UserAdapter(this,
                R.layout.row_user, userList);

        listViewUser = (ListView)findViewById(R.id.listViewUser);

        listViewUser.setAdapter(adapter);

        listViewUser.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {

                User user = (User) arg0.getItemAtPosition(arg2);

                Intent i = new Intent(getApplicationContext(), UserDetails.class);
                int ID = user.getId();
                String name = user.getName();
                String userName = user.getUsername();
                String email = user.getEmail();
                Address address = user.getAddress();
                String phone = user.getPhone();
                String website = user.getWebsite();
                Company company = user.getCompany();
//
//                User userDetails = new User();
//                userDetails.setId(ID);

                i.putExtra("user_id", ID);
                i.putExtra("name", name);
                i.putExtra("userName", userName);
                i.putExtra("email", email);
                i.putExtra("address", address);
                i.putExtra("phone", phone);
                i.putExtra("website", website);
                i.putExtra("company", company);
                startActivity(i);
            }

        });
    }
}
