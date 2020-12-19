import com.sun.org.apache.bcel.internal.generic.InstructionConstants;

import java.util.LinkedList;
import java.util.List;
public class Test
{
    public static void main(String[] args) {
        Client client_1=new Client();
        client_1.name="www";
        client_1.adress="GUET";
        client_1.phone="123456";
        client_1.userName="1";
        client_1.indentList=new LinkedList<>();

        Indent indent=new Indent();
        indent.indentId="1_45";
        indent.ammount=404F;
        indent.client=client_1;

        client_1.indentList.add(indent);

        System.out.println(client_1.indentList.get(0).ammount);

    }
}
