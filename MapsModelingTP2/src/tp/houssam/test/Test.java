package tp.houssam.test;

import java.util.HashMap;
import java.util.Map;

import maps.MapsPackage;
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
		
		//Je charge l'instance map.xmi du méta-modèle maps.ecore
		Resource resource = chargerModele("model/map.xmi", MapsPackage.eINSTANCE);
		if (resource == null) System.err.println(" Erreur de chargement du modèle");
		
		
		//Instruction récupérant le modèle sous forme d'arbre a  partir de la classe racine "map"
		map maMap = (map) resource.getContents().get(0);
						
		System.out.println(maMap.getName());
				
		System.out.println(" **************************************************************.");		
		System.out.println(" afficher les noms de toutes les rues (Street) d’une map donnee.");
		System.out.println(" **************************************************************.");
		
		ToutesLesRues();
		

		System.out.println(" **************************************************************.");		
		System.out.println(" Les rues pietonnes (Pedetrian) dont la longueur depasse 1000m.");
		System.out.println(" **************************************************************.");
		
		ToutesRuesPietonnes1000();

		System.out.println(" **************************************************************.");		
		System.out.println(" Pour un nom de boulevard donne (Boulevard), trouver tous les noms des routes adjacentes..");
		System.out.println(" **************************************************************.");
		
		
		RoutesAdjacentes("");

		System.out.println(" **************************************************************.");		
		System.out.println(" Pour un nom de place (Square) donne, trouver tous les noms des routes la bordant..");
		System.out.println(" **************************************************************.");
		
		RoutesBordantLaPlace("");
	}
	
	
	public static Resource chargerModele(String uri, EPackage pack) {
		   Resource resource = null;
		   try {
		      URI uriUri = URI.createURI(uri);
		      Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		      resource = (new ResourceSetImpl()).createResource(uriUri);
		      XMLResource.XMLMap xmlMap = new XMLMapImpl();
		      xmlMap.setNoNamespacePackage(pack);
		      Map options = new HashMap();
		      options.put(XMLResource.OPTION_XML_MAP, xmlMap);
		      resource.load(options);
		   }
		   catch(Exception e) {
		      System.err.println("ERREUR chargement du modÃ¨le : "+e);
		      e.printStackTrace();
		   }
		   return resource;
	}
	
	/**
	 * (1) First method
	 */
	public static void ToutesLesRues(){
		
	}

	/**
	 * (2) First method
	 */
	public static void ToutesRuesPietonnes1000(){
		
	}
	

	/**
	 * (3) First method
	 */
	public static void RoutesAdjacentes(String boulevard){
		
	}
	

	/**
	 * (4) First method
	 */
	public static void RoutesBordantLaPlace(String nom_place){
		
	}
}