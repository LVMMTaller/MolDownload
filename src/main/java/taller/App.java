package taller;


import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class App
{
    static String PROPS = "MolecularFormula,MolecularWeight,CanonicalSMILES,XLogP,ExactMass,TPSA,Charge,HBondDonorCount,HBondAcceptorCount";
    static String CID = "2244,2245";

    static String CAS_ID = "50-78-2";
    static String URL_PUBCHEM_PATH_SDF = "https://pubchem.ncbi.nlm.nih.gov/rest/pug/compound/cid/"+CID+"/sdf";
    static String URL_PUBCHEM_PATH_PROPERTY = "https://pubchem.ncbi.nlm.nih.gov/rest/pug/compound/cid/"+CID+"/property/"+PROPS+"/CSV";

    static String URL_CAS_PATH_INFO = "https://commonchemistry.cas.org/api/detail?cas_rn="+CAS_ID;

    public static void saveInfo(String data,String fileName) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(fileName);
        pw.print(data);
        pw.close();
    }

    public static void main( String[] args ) throws FileNotFoundException {
        saveInfo(APIConsume.consumeApi(URL_PUBCHEM_PATH_SDF),"mols.sdf");

        saveInfo(APIConsume.consumeApi(URL_PUBCHEM_PATH_PROPERTY),"pubchem_info.csv");

        saveInfo(APIConsume.consumeApi(URL_CAS_PATH_INFO),"cas_info.json");
    }
}
