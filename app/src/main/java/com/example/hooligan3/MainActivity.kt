package com.example.hooligan3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import android.Manifest
import androidx.core.app.ActivityCompat
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.location.LocationListener
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.databinding.ViewDataBinding
import android.widget.AdapterView
import android.view.View
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MainActivity : AppCompatActivity() {

    private lateinit var locationManager: LocationManager
    private lateinit var locationListener: LocationListener
    var binding: ViewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        locationManager = getSystemService(LOCATION_SERVICE) as LocationManager

        locationListener = object : LocationListener {
            override fun onLocationChanged(location: Location) {
                Log.d("Location", "Latitude: ${location.latitude}, Longitude: ${location.longitude}")
            }

            override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
            }

            override fun onProviderEnabled(provider: String) {
            }

            override fun onProviderDisabled(provider: String) {
            }
        }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 1)
        } else {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0f, locationListener)
        }

        val spinner = findViewById<Spinner>(R.id.team_spinner)
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                // Code to handle the selected item
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Code to handle the case where no item is selected
            }
        } as AdapterView.OnItemSelectedListener
        val mlbTeams = arrayOf(
            "Arizona Diamondbacks",
            "Atlanta Braves",
            "Baltimore Orioles",
            "Boston Red Sox",
            "Chicago Cubs",
            "Chicago White Sox",
            "Cincinnati Reds",
            "Cleveland Guardians",
            "Colorado Rockies",
            "Detroit Tigers",
            "Houston Astros",
            "Kansas City Royals",
            "Los Angeles Angels",
            "Los Angeles Dodgers",
            "Miami Marlins",
            "Milwaukee Brewers",
            "Minnesota Twins",
            "New York Mets",
            "New York Yankees",
            "Oakland Athletics",
            "Philadelphia Phillies",
            "Pittsburgh Pirates",
            "San Diego Padres",
            "San Francisco Giants",
            "Seattle Mariners",
            "St. Louis Cardinals",
            "Tampa Bay Rays",
            "Texas Rangers",
            "Toronto Blue Jays",
            "Washington Nationals"
        )

        val nbaTeams = arrayOf(
            "Atlanta Hawks",
            "Boston Celtics",
            "Brooklyn Nets",
            "Charlotte Hornets",
            "Chicago Bulls",
            "Cleveland Cavaliers",
            "Dallas Mavericks",
            "Denver Nuggets",
            "Detroit Pistons",
            "Golden State Warriors",
            "Houston Rockets",
            "Indiana Pacers",
            "Los Angeles Clippers",
            "Los Angeles Lakers",
            "Memphis Grizzlies",
            "Miami Heat",
            "Milwaukee Bucks",
            "Minnesota Timberwolves",
            "New Orleans Pelicans",
            "New York Knicks",
            "Oklahoma City Thunder",
            "Orlando Magic",
            "Philadelphia 76ers",
            "Phoenix Suns",
            "Portland Trail Blazers",
            "Sacramento Kings",
            "San Antonio Spurs",
            "Toronto Raptors",
            "Utah Jazz",
            "Washington Wizards"
        )

        val nflTeams = arrayOf(
            "Arizona Cardinals",
            "Atlanta Falcons",
            "Baltimore Ravens",
            "Buffalo Bills",
            "Carolina Panthers",
            "Chicago Bears",
            "Cincinnati Bengals",
            "Cleveland Browns",
            "Dallas Cowboys",
            "Denver Broncos",
            "Detroit Lions",
            "Green Bay Packers",
            "Houston Texans",
            "Indianapolis Colts",
            "Jacksonville Jaguars",
            "Kansas City Chiefs",
            "Las Vegas Raiders",
            "Los Angeles Chargers",
            "Los Angeles Rams",
            "Miami Dolphins",
            "Minnesota Vikings",
            "New England Patriots",
            "New Orleans Saints",
            "New York Giants",
            "New York Jets",
            "Philadelphia Eagles",
            "Pittsburgh Steelers",
            "San Francisco 49ers",
            "Seattle Seahawks",
            "Tampa Bay Buccaneers",
            "Tennessee Titans",
            "Washington Commanders"
        )

        val nhlTeams = arrayOf(
            "Anaheim Ducks",
            "Arizona Coyotes",
            "Boston Bruins",
            "Buffalo Sabres",
            "Calgary Flames",
            "Carolina Hurricanes",
            "Chicago Blackhawks",
            "Colorado Avalanche",
            "Columbus Blue Jackets",
            "Dallas Stars",
            "Detroit Red Wings",
            "Edmonton Oilers",
            "Florida Panthers",
            "Los Angeles Kings",
            "Minnesota Wild",
            "Montreal Canadiens",
            "Nashville Predators",
            "New Jersey Devils",
            "New York Islanders",
            "New York Rangers",
            "Ottawa Senators",
            "Philadelphia Flyers",
            "Pittsburgh Penguins",
            "San Jose Sharks",
            "Seattle Kraken",
            "St. Louis Blues",
            "Tampa Bay Lightning",
            "Toronto Maple Leafs",
            "Vancouver Canucks",
            "Vegas Golden Knights",
            "Washington Capitals",
            "Winnipeg Jets"
        )

        val eplTeams = arrayOf(
            "Arsenal",
            "Aston Villa",
            "Bournemouth",
            "Brentford",
            "Brighton & Hove Albion",
            "Chelsea",
            "Crystal Palace",
            "Everton",
            "Fulham",
            "Leeds United",
            "Leicester City",
            "Liverpool",
            "Manchester City",
            "Manchester United",
            "Newcastle United",
            "Nottingham Forest",
            "Southampton",
            "Tottenham Hotspur",
            "West Ham United",
            "Wolverhampton Wanderers"
        )

        val barToLocations = hashMapOf(
            "Iron Abbey" to LatLng(40.1743, -75.3953), // Horsham, PA
            "Liverpool Bar" to LatLng(40.7128, -74.0060), // New York, NY
            "Misconduct Tavern" to LatLng(39.9473, -75.1633), // Philadelphia, PA
            "O'Neals Pub" to LatLng(39.9383, -75.1533), // Philadelphia, PA
            "The Black Sheep" to LatLng(39.9493, -75.1723), // Philadelphia, PA
            "Tir Na Nog" to LatLng(39.9553, -75.1633), // Philadelphia, PA
            "Fado" to LatLng(39.9473, -75.1633), // Philadelphia, PA
            "Cavanaugh's Headhouse Square" to LatLng(39.9403, -75.1473), // Philadelphia, PA
            "Founding Fathers" to LatLng(39.9393, -75.1633), // Philadelphia, PA
            "Big Charlie's Saloon" to LatLng(39.9496, -75.1634), // Philadelphia, PA
            "Jack's NYB" to LatLng(39.9242, -75.1739), // Philadelphia, PA
            // Add more bars and locations here
        )

        val barToTeams = hashMapOf(
            "Iron Abbey" to arrayOf("Liverpool"),
            "Misconduct Tavern" to arrayOf("Arsenal"),
            "O'Neals Pub" to arrayOf("Everton"),
            "The Black Sheep" to arrayOf("Manchester United"),
            "Tir Na Nog" to arrayOf("Chelsea", "Manchester City"),
            "Fado" to arrayOf("Crystal Palace"),
            "Cavanaugh's Headhouse Square" to arrayOf("Newcastle"),
            "Founding Fathers" to arrayOf("Tottenham"),
            "Big Charlie's Saloon" to arrayOf("Kansas City Chiefs"),
            "Jack's NYB" to arrayOf("St. Louis Blues"),
            // Add more bars and teams here
        )

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(this@MainActivity, "Selected: ${parent?.getItemAtPosition(position)}", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == 1) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.checkSelfPermission(
                        this,
                        Manifest.permission.ACCESS_FINE_LOCATION
                    ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                        this,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return
                }
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0f, locationListener)
            } else {
                Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
            }
        }
    }
}