package com.poc.springboot.service;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.poc.springboot.model.OOSProvider;

@Component
public class OOSService {

	private static List<OOSProvider> providersList = new ArrayList<>();

	static {

		OOSProvider provider1 = new OOSProvider("1211", "NPI ID", "01/18/2018", "01/18/2018");

		OOSProvider provider2 = new OOSProvider("1212", "NPI ID", "01/18/2018", "01/18/2018");

		OOSProvider provider3 = new OOSProvider("1213", "NPI ID", "01/18/2018", "01/18/2018");

		OOSProvider provider4 = new OOSProvider("1214", "NPI ID", "01/18/2018", "01/18/2018");

		OOSProvider provider5 = new OOSProvider("1215", "NPI ID", "01/18/2018", "01/18/2018");

		OOSProvider provider6 = new OOSProvider("1216", "NPI ID", "01/18/2018", "01/18/2018");

		OOSProvider provider7 = new OOSProvider("1217", "NPI ID", "01/18/2018", "01/18/2018");

		OOSProvider provider8 = new OOSProvider("1218", "NPI ID", "01/18/2018", "01/18/2018");

		OOSProvider provider9 = new OOSProvider("1219", "NPI ID", "01/18/2018", "01/18/2018");

		OOSProvider provider10 = new OOSProvider("1210", "NPI ID", "01/18/2018", "01/18/2018");

		OOSProvider provider11 = new OOSProvider("1221", "NPI ID", "01/18/2018", "01/18/2018");

		OOSProvider provider12 = new OOSProvider("1222", "NPI ID", "01/18/2018", "01/18/2018");

		OOSProvider provider13 = new OOSProvider("1223", "NPI ID", "01/18/2018", "01/18/2018");

		OOSProvider provider14 = new OOSProvider("1224", "NPI ID", "01/18/2018", "01/18/2018");

		OOSProvider provider15 = new OOSProvider("1225", "NPI ID", "01/18/2018", "01/18/2018");

		OOSProvider provider16 = new OOSProvider("1226", "NPI ID", "01/18/2018", "01/18/2018");

		OOSProvider provider17 = new OOSProvider("1227", "NPI ID", "01/18/2018", "01/18/2018");

		OOSProvider provider18 = new OOSProvider("1228", "NPI ID", "01/18/2018", "01/18/2018");

		OOSProvider provider19 = new OOSProvider("1229", "NPI ID", "01/18/2018", "01/18/2018");

		OOSProvider provider20 = new OOSProvider("1220", "NPI ID", "01/18/2018", "01/18/2018");

		providersList.add(provider1);
		providersList.add(provider2);
		providersList.add(provider3);
		providersList.add(provider4);
		providersList.add(provider5);
		providersList.add(provider6);
		providersList.add(provider7);
		providersList.add(provider8);
		providersList.add(provider9);
		providersList.add(provider10);
		providersList.add(provider11);
		providersList.add(provider12);
		providersList.add(provider13);
		providersList.add(provider14);
		providersList.add(provider15);
		providersList.add(provider16);
		providersList.add(provider17);
		providersList.add(provider18);
		providersList.add(provider19);
		providersList.add(provider20);

	}

	public List<OOSProvider> retrieveAllOOSProviders() {
		return providersList;
	}

	public OOSProvider retrieveProvider(String providerID) {

		for (OOSProvider oosProvider : providersList) {
			if (oosProvider.getProviderId().equals(providerID)) {
				return oosProvider;
			}
		}

		return null;
	}
	
	public List<OOSProvider> deleteProvider(String providerId) throws ConcurrentModificationException{
		List<OOSProvider> newprovidersList = new ArrayList<>();
		
	 for (OOSProvider oosProvider : providersList) {
			if (oosProvider.getProviderId().equals(providerId)) {
				//newprovidersList.remove(oosProvider);
			}else{
			newprovidersList.add(oosProvider);
			}
		}
		
		return newprovidersList;
	}

	public List<OOSProvider> addProvider(OOSProvider provider) {
		
		List<OOSProvider> newprovidersList = providersList;
		newprovidersList.add(provider);
		return newprovidersList;
	}
}
