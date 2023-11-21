package br.com.aab.algorithms;

import java.io.File;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;

public class BreadthFirstSearchSubDirectory {
    private File fileCurrPath = Paths.get("").toAbsolutePath().toFile();

    public List<String> listDirectory() {
        List<String> directory = new LinkedList<>();
        Queue<File> fileSystemQueue = new LinkedList<>() {{ add(fileCurrPath); }};
        while (! fileSystemQueue.isEmpty()) {
            File[] files = Optional.ofNullable(fileSystemQueue.poll().listFiles()).orElse(new File[0]);
            for (File file: files) {
                if (file.isDirectory()) {
                    fileSystemQueue.add(file);
                } else {
                    directory.add(file.getAbsoluteFile().toString());
                }
            }
        }
        return directory;
    }

    public static void main(String[] args) {
        BreadthFirstSearchSubDirectory bfs = new BreadthFirstSearchSubDirectory();
        bfs.listDirectory().stream().limit(50).forEach(System.out::println);
    }
}
