package service;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import model.ProdutoSuplemento;

public class JsonPersistenceSuplemento {
    private static final String DIRECTORY_PATH = "src/data";
    private final String filePath;

    public JsonPersistenceSuplemento(String fileName) {
        String currentDirectory = System.getProperty("user.dir");
        this.filePath = currentDirectory + File.separator + DIRECTORY_PATH + File.separator + fileName;
    }

    public void salvarDados(List<ProdutoSuplemento> dados) {
        File directory = new File(DIRECTORY_PATH);
        if (!directory.exists()) {
            directory.mkdirs(); // Cria o diretório se não existir
        }

        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile(); // Cria o arquivo se não existir
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (Writer writer = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(dados, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<ProdutoSuplemento> carregarDados() {
        List<ProdutoSuplemento> dados = new ArrayList<ProdutoSuplemento>();

        try {
            File file = new File(filePath);
            if (file.exists()) {
                Type type = new TypeToken<List<ProdutoSuplemento>>() {}.getType();
                Gson gson = new GsonBuilder().setLenient().create();
                JsonReader reader = new JsonReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
                dados = gson.fromJson(reader, type);
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dados;
    }
}
