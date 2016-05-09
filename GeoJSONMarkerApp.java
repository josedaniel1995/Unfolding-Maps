package de.fhpotsdam.unfolding.examples.data;

import java.util.List;

import processing.core.PApplet;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.GeoJSONReader;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.providers.StamenMapProvider;
import de.fhpotsdam.unfolding.utils.MapUtils;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import de.fhpotsdam.unfolding.providers.Microsoft;

public class GeoJSONMarkerApp extends PApplet {

	UnfoldingMap map;
	
	Location houseLocation = new Location(-16.426760,-71.519359);
	
	SimplePointMarker houseMarker = new SimplePointMarker(houseLocation);
	


	public void setup() {
		size(800, 600, OPENGL);
		smooth();
		fill(0, 0, 255);
		map = new UnfoldingMap(this, new Google.GoogleTerrainProvider());
		map.zoomToLevel(26);
		
		map.panTo(houseLocation);
		map.setPanningRestriction(houseLocation, 50);
		map.addMarker(houseMarker);

		MapUtils.createDefaultEventDispatcher(this, map);

	}

	public void draw() {
		background(160);
		map.draw();
	}

	public void keyPressed() {
		if (key == ' ') {
			map.getDefaultMarkerManager().toggleDrawing();
		}
	}

}