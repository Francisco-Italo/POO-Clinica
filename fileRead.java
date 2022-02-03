import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

class fileRead {

    public static HashMap<String, Paciente> readFilePaciente(){
        Locale.setDefault(Locale.US);
        String filePaciente = "/home/itsfrancisco/Área de Trabalho/Pacientes.txt";
        File file = new File(filePaciente);

        HashMap<String, Paciente> mapping = new HashMap<>();
        try(Scanner inFile = new Scanner(file, StandardCharsets.UTF_8);){
            while(inFile.hasNext()){
                String name = inFile.nextLine();
                String endereco = inFile.nextLine();
                String numeroTel = inFile.nextLine();
                String cpf = inFile.nextLine();
                byte dia = inFile.nextByte(); byte mes = inFile.nextByte(); int ano = inFile.nextInt();
                inFile.nextLine();
                char sexo = inFile.next().charAt(0); inFile.nextLine();
                String natu = inFile.nextLine();
                
                Paciente p = new Paciente(name, endereco, numeroTel, cpf, new Data(dia, mes, ano), sexo, natu);
                mapping.put(cpf, p);
            }   
        }catch(InputMismatchException e) {
            System.out.println("Entrada inválida.");
        }catch(FileNotFoundException e) {
            System.err.println("Arquivo não encontrado.");
        }catch(IOException e) {
            System.err.println("Exceção de E/S");
        }
        return mapping;
    }

    public static HashMap<String, Clinico> readFileClinico(){
        Locale.setDefault(Locale.US);
        String fileClinico = "/home/itsfrancisco/Área de Trabalho/Medicos.txt";
        File file = new File(fileClinico);

        HashMap<String, Clinico> mapping = new HashMap<>();
        try(Scanner inFile = new Scanner(file, StandardCharsets.UTF_8);){
            while(inFile.hasNext()){
                while(inFile.hasNext()){
                    String name = inFile.nextLine();
                    String endereco = inFile.nextLine();
                    String numeroTel = inFile.nextLine();
                    String reg = inFile.nextLine();
                    String spec = inFile.nextLine();
                
                    Clinico c = new Clinico(name, endereco, numeroTel, reg, spec);
                    mapping.put(reg, c);
                }
            }   
        }catch(InputMismatchException e) {
            System.out.println("Entrada inválida.");
        }catch(FileNotFoundException e) {
            System.err.println("Arquivo não encontrado.");
        }catch(IOException e) {
            System.err.println("Exceção de E/S");
        }

        return mapping;
    }

    /*public static HashMap<String, ArrayList<Consulta>> readFileConsulta(){
        Locale.setDefault(Locale.US);
        String fileConsulta = "/home/itsfrancisco/Área de Trabalho/Consultas.txt";
        File file = new File(fileConsulta);

        HashMap<String, Consulta> mapping = new HashMap<>();
        try(Scanner inFile = new Scanner(file, StandardCharsets.UTF_8);){
            while(inFile.hasNext()){
                while(inFile.hasNext()){
                    String name = inFile.nextLine();
                    String endereco = inFile.nextLine();
                    String numeroTel = inFile.nextLine();
                    String reg = inFile.nextLine();
                    String spec = inFile.nextLine();
                
                    Clinico c = new Clinico(name, endereco, numeroTel, reg, spec);
                    
                }
            }   
        }catch(InputMismatchException e) {
            System.out.println("Entrada inválida.");
        }catch(FileNotFoundException e) {
            System.err.println("Arquivo não encontrado.");
        }catch(IOException e) {
            System.err.println("Exceção de E/S");
        }

        return mapping;
    }

    public static HashMap<String, ArrayList<Prontuario>> readFileProntuario(){
        Locale.setDefault(Locale.US);
        String fileProntuario = "/home/itsfrancisco/Área de Trabalho/Prontuarios.txt";
        File file = new File(fileProntuario);

        HashMap<String, ArrayList<Prontuario>> mapping = new HashMap<>();
        try(Scanner inFile = new Scanner(file, StandardCharsets.UTF_8);){
            while(inFile.hasNext()){
                while(inFile.hasNext()){
                    String cpfPacPront = inFile.nextLine();
                    String sintomas = inFile.nextLine();
                    String diag = inFile.nextLine();
                
                    Prontuario pront = new Prontuario(cpfPacPront, sintomas, diag);
                    mapping.put(cpfPacPront, pront);
                }
            }   
        }catch(InputMismatchException e) {
            System.out.println("Entrada inválida.");
        }catch(FileNotFoundException e) {
            System.err.println("Arquivo não encontrado.");
        }catch(IOException e) {
            System.err.println("Exceção de E/S");
        }

        return mapping;
    }*/    
}
