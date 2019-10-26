package com.example.devfest.ui.frgs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.devfest.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.fragment_map.*
import kotlinx.android.synthetic.main.fragment_map.view.*


class MapFragment : Fragment(), OnMapReadyCallback {

    companion object {
        const val MAP_VIEW_BUNDLE_KEY = "MapViewBundleKey"
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        googleMap?.let {
            val algiers = LatLng(36.7537, 3.0587)
            it.addMarker(MarkerOptions().position(algiers).title("Marker in Algiers"))

            val v1 = LatLng(36.71, 3.14)
            it.addMarker(MarkerOptions().position(v1).title("Marker in Algiers"))
            val v2 = LatLng(36.7203, 3.1466)
            it.addMarker(MarkerOptions().position(v2).title("Marker in Algiers"))
            val v3 = LatLng(36.7115, 3.1056)
            it.addMarker(MarkerOptions().position(v3).title("Marker in Algiers"))

            it.animateCamera(CameraUpdateFactory.newLatLngZoom(algiers, 15f))

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_map, container, false)
        var mapViewBundle: Bundle? = null
        if (savedInstanceState != null) {
            mapViewBundle = savedInstanceState.getBundle(MAP_VIEW_BUNDLE_KEY)
        }
        view.mapView.onCreate(savedInstanceState)
        view.mapView.getMapAsync(this)
        return view
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        var mapViewBundle = outState.getBundle(MAP_VIEW_BUNDLE_KEY)
        if (mapViewBundle == null) {
            mapViewBundle = Bundle()
            outState.putBundle(MAP_VIEW_BUNDLE_KEY, mapViewBundle)
        }
        mapView.onSaveInstanceState(mapViewBundle)
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onStart() {
        super.onStart()
        mapView.onStart()
    }

    override fun onStop() {
        super.onStop()
        mapView.onStop()
    }

    override fun onPause() {
        mapView.onPause()
        super.onPause()
    }

    override fun onDestroy() {
        mapView?.onDestroy()
        super.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }

}
