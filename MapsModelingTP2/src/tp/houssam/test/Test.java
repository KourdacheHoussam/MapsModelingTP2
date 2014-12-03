package tp.houssam.test;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Map;

import maps.Boulevard;
import maps.MapsPackage;
import maps.Pedestrian;
import maps.Road;
import maps.map;

import org.eclipse.emf.common.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLMapImpl;

public class Test {

	public static void main(String[] args) {

		// Je charge l'instance map.xmi du méta-modèle maps.ecore
		Resource resource = chargerModele("model/map.xmi",
				MapsPackage.eINSTANCE);
		if (resource == null)
			System.err.println(" Erreur de chargement du modèle");

		// Instruction récupérant le modèle sous forme d'arbre a partir de la
		// classe racine "map"
		map maMap = (map) resource.getContents().get(0);

		System.out.println(maMap.getName());

		System.out
				.println(" **************************************************************.");
		System.out
				.println(" afficher les noms de toutes les rues (Street) d’une map donnee.");
		System.out
				.println(" **************************************************************.");

		ToutesLesRues(maMap);

		System.out
				.println(" **************************************************************.");
		System.out
				.println(" Les rues pietonnes (Pedetrian) dont la longueur depasse 1000m.");
		System.out
				.println(" **************************************************************.");

		ToutesRuesPietonnes1000(maMap);

		System.out
				.println(" **************************************************************.");
		System.out
				.println(" Pour un nom de boulevard donne (Boulevard), trouver tous les noms des routes adjacentes..");
		System.out
				.println(" **************************************************************.");

		RoutesAdjacentes(maMap, "Victor Hugo");

		System.out
				.println(" **************************************************************.");
		System.out
				.println(" Pour un nom de place (Square) donne, trouver tous les noms des routes la bordant..");
		System.out
				.println(" **************************************************************.");

		RoutesBordantLaPlace(maMap, "");
	}

	public static Resource chargerModele(String uri, EPackage pack) {
		Resource resource = null;
		try {
			URI uriUri = URI.createURI(uri);
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
					"xmi", new XMIResourceFactoryImpl());
			resource = (new ResourceSetImpl()).createResource(uriUri);
			XMLResource.XMLMap xmlMap = new XMLMapImpl();
			xmlMap.setNoNamespacePackage(pack);
			Map options = new HashMap();
			options.put(XMLResource.OPTION_XML_MAP, xmlMap);
			resource.load(options);
		} catch (Exception e) {
			System.err.println("ERREUR chargement du modÃ¨le : " + e);
			e.printStackTrace();
		}
		return resource;
	}

	/**
	 * (1) First method
	 */
	public static void ToutesLesRues(map map) {
		EList<Road> roads = map.getRoads();
		for (int i = 0; i < roads.size(); i++) {
			System.out.println("Route : " + roads.get(i).getName());
		}
	}

	/**
	 * (2) second method
	 */
	public static void ToutesRuesPietonnes1000(map map) {
		EList<Road> roads = map.getRoads();
		for (int i = 0; i < roads.size(); i++) {
			if (roads.get(i) != null && roads.get(i) instanceof Pedestrian) {
				Pedestrian new_pedestrian = (Pedestrian) roads.get(i);
				if (new_pedestrian.getLength() > 1000) {
					System.out.println("R.piétone : "
							+ new_pedestrian.getName());
				}
			}
		}
	}

	/**
	 * (3) third method
	 */
	public static void RoutesAdjacentes(map map, String nom_boulevard) {
		EList<Road> roads = map.getRoads();
	
		for (int i = 0; i < roads.size(); i++) {
			if (roads.get(i) != null && roads.get(i) instanceof Boulevard
					&& roads.get(i).getName().equalsIgnoreCase(nom_boulevard)) {
				EList<Road> adjacentes = roads.get(i).getMeet();
				for (int j = 0; j < adjacentes.size(); j++) {
					System.out.println("Route adjacente : "+adjacentes.get(j).getName());
				}
			}
		}	
	}

	/**
	 * (4) fourth method
	 */
	public static void RoutesBordantLaPlace(map map, String nom_place) {

	}
}