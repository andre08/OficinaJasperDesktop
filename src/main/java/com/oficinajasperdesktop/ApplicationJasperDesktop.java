package com.oficinajasperdesktop;

import com.oficinajasperdesktop.dao.ClienteDao;
import com.oficinajasperdesktop.dao.ConnectionManager;
import com.oficinajasperdesktop.model.Cliente;
import java.io.File;
import java.util.HashMap;
import java.util.Scanner;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;

public class ApplicationJasperDesktop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        ClienteDao clienteDao = new ClienteDao();
        Cliente cliente = new Cliente();
        Scanner entrada = new Scanner(System.in);
        int vMenu = -1;

        do {
            System.out.println("Menu");
            System.out.println("-------------------------------");
            System.out.println("1. Incluir Cliente");
            System.out.println("2. Alterar Cliente");
            System.out.println("3. Excluir Cliente");
            System.out.println("4. Imprimir Detalhe de Cliente");
            System.out.println("5. Listar Cliente");
            System.out.println("6. Imprimir Lista de Cliente");
            System.out.println("0. Sair");

            System.out.print("Escolha uma opção: ");
            vMenu = entrada.nextInt();
            System.out.println("Opção escolhida -> " + vMenu);
            switch (vMenu) {
                case 1:
                    System.out.println("1. Incluir Cliente");
                    System.out.println("-------------------------------");

                    String vNome;
                    String vCPF;
                    System.out.println("informe o nome:");
                    vNome = entrada.next();
                    System.out.println("informe o cpf:");
                    vCPF = entrada.next().substring(0, 11);

                    cliente.setNome(vNome);
                    cliente.setCpf(vCPF);
                    clienteDao.save(cliente);

                case 2:
                    System.out.println("2. Alterar Cliente");
                case 3:
                    System.out.println("3. Excluir Cliente");
                case 4:
                    System.out.println("4. Imprimir Detalhe de Cliente");
                case 5:
                    System.out.println("5. Listar Cliente");
                    System.out.println("-------------------------------");
                    for (Cliente vItem : clienteDao.getAll()) {
                        System.out.println("Id: " + vItem.getId().toString());
                        System.out.println("Nome: " + vItem.getNome());
                        System.out.println("CPF: " + vItem.getCpf());

                    }
                case 6:
                    System.out.println("6. Imprimir Lista de Cliente");
                    System.out.println("impressão");

                    String origem = "Lista de Clientes.jasper";
                    String destino = "lista.pdf";

                    try {

                        HashMap<String, Object> resultado = new HashMap<String, Object>();
                        JasperRunManager.runReportToPdfFile("c:/jasper/" + origem, "c:/jasper/" + destino, resultado, ConnectionManager.getConnection());
                        File file = new File("c:/jasper/" + destino);
                        System.out.println("Arquivo " + "c:/jasper/" + destino + " criado com sucesso");

                    } catch (JRException e) {

                        System.out.println("Não foi possível gerar o relatório");

                    }

                    break;
                case 0:
                    System.out.println("Obrigado por utilizar o aplicativo");
                    break;
                default:
                    System.out.print("Opção inválida");
                    vMenu = -1;
            }

        } while (vMenu != 0);

    }

}
