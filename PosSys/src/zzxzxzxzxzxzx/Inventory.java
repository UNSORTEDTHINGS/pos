package zzxzxzxzxzxzx;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.event.PrintJobAdapter;
import javax.print.event.PrintJobEvent;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class Inventory {

	Patent patent;
	Pharmcis pharmcis;
	Product product;
	List<Patent> patents;
	List<Pharmcis> pharmcises;
	List<Product> products;
	private Map<String, Product> searchForSKUMap;


	public Inventory() {
		this.patents = new ArrayList<>();
		this.pharmcises = new ArrayList<>();
		this.products = new ArrayList<>();
		searchForSKUMap = new HashMap<>();
		mapContents();
	}
	public Patent getPatent() {
		return patent;
	}
	public void setPatent(Patent patent) {
		this.patent = patent;
	}
	public Pharmcis getPharmcis() {
		return pharmcis;
	}
	public void setPharmcis(Pharmcis pharmcis) {
		this.pharmcis = pharmcis;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public List<Patent> getPatents() {
		return patents;
	}
	public void setPatents(List<Patent> patents) {
		this.patents = patents;
	}
	public List<Pharmcis> getPharmcises() {
		return pharmcises;
	}
	public void setPharmcises(List<Pharmcis> pharmcises) {
		this.pharmcises = pharmcises;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	private void mapContents() {
		Product brofeenProduct = new Product("075720481279","WATTER", 12.45);
		products.add(brofeenProduct);
		searchForSKUMap = products.stream()
				.collect(Collectors.toMap((product) -> product.getProductNumber(), Function.identity()));
		
	}
	
	public void PrintSlip(String file,int copies) throws PrintException,
	IOException{

		PrintService ps = PrintServiceLookup.lookupDefaultPrintService();
		
		DocPrintJob job = ps.createPrintJob();
	
		job.addPrintJobListener(new PrintJobAdapter() {
			
			public void printDataTransferCompleted(PrintJobEvent event){
				JOptionPane.showMessageDialog(null,"Data transfer complete");
			}
			public void printJobNoMoreEvents(PrintJobEvent event){
				JOptionPane.showMessageDialog(null,"Received no more events");
			}
			public void printJobCanceled(PrintJobEvent event){
				JOptionPane.showMessageDialog(null,"Printing Has been Canceled");
			}
			public void printJobFailed(PrintJobEvent event){
				JOptionPane.showMessageDialog(null,"Faild To print");
			}
			
		});
		FileInputStream fis=new FileInputStream(file);
		
		Doc doc=new SimpleDoc(fis, DocFlavor.INPUT_STREAM.AUTOSENSE, null);

		PrintRequestAttributeSet attrib=new HashPrintRequestAttributeSet();
		
		attrib.add(new Copies(copies));
		
		job.print(doc, attrib);
	}
	public Boolean lookupFor(String sku) {
		boolean found = false;
			if (searchForSKUMap.containsKey(sku)) {
			Product exsistProduct = searchForSKUMap.get(sku);
			setProduct(exsistProduct);
			found = true;
		} else {
			JOptionPane.showMessageDialog(null, sku + " NOT FOUND");
		}
			return found;
	}

}
