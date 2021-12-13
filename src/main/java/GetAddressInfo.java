import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.poi.ss.formula.functions.Address;

@WebServlet("/GetAddressInfo")
public class GetAddressInfo extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public GetAddressInfo() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String postal_Code = request.getParameter("Postal_Code");
        String mobile_Number = request.getParameter("Mobile_Number");
        String DO_NO = request.getParameter("DO_NO");
        String name = request.getParameter("Name");
        String remarks = request.getParameter("Remarks");
        String unit_Number = request.getParameter("Unit_Number");
        AddressService addressService = new AddressService();
        //addressService.addMemberInfo(DO_NO, getAddressInfo(unit_Number, postal_Code), mobile_Number, name, remarks, unit_Number, postal_Code);
        System.out.println(DO_NO.toUpperCase() + ", " + getAddressInfo(unit_Number, postal_Code) + ", " + name.toUpperCase()+ ", " + mobile_Number.toUpperCase() + ", " + remarks.toUpperCase());
        response.getWriter().print(DO_NO.toUpperCase() + ", " + getAddressInfo(unit_Number, postal_Code) + ", " + name.toUpperCase() + ", " + mobile_Number.toUpperCase() + ", " + remarks.toUpperCase());

    }

    public static String getAddressInfo(String unit_Number, String postal_Code) throws IOException {

        HttpURLConnection connection = (HttpURLConnection) new URL("https://developers.onemap.sg/commonapi/search?searchVal=" + postal_Code + "&returnGeom=N&getAddrDetails=Y").openConnection();

        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode == 200) {
            String response = "";
            Scanner scanner = new Scanner(connection.getInputStream());
            while (scanner.hasNextLine()) {
                response += scanner.nextLine();
                response += "\n";
            }
            scanner.close();
            ObjectMapper om = new ObjectMapper();
            Root root = om.readValue(response, Root.class);
            for (Result address : root.getResults()) {
               // System.out.println(address.getADDRESS());
                return  address.getBLK_NO().toUpperCase() + "||" + address.getROAD_NAME().toUpperCase() + "||" + address.getBUILDING().toUpperCase() + "||#" + unit_Number.toUpperCase() + "||" + "S" + address.getPOSTAL().toUpperCase();
            }
        }
        return null;
    }
}
