package com.epam.courses.jf.practice.second;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.StandardCopyOption;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Базовый класс для юнит-тестирования задач, использующих файлы в процессе решения.
 */
public class AbstractTaskWithResourcesTest extends AbstractTaskTest implements Closeable {

    /** Множество использованных временных файлов */
    private final Deque<File> FILES = new LinkedList<>();

    /**
     * Подготавливает временный файл для тестирования.
     * @return Подготовленный временный файл.
     */
    protected File prepareFile() {
        try {
            File tmpFile = File.createTempFile("2-epam-spring-2016", ".tmp");
            FILES.push(tmpFile);
            return tmpFile;
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Подготавливает файл для тестирования, копируя его содержимое во временный файл.
     * @param file Файл с исходными данными.
     * @return Подготовленный для тестирования файл.
     */
    protected File prepareFile(File file) {
        try {
            File tmpFile = this.prepareFile();
            Files.copy(file.toPath(), tmpFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            return tmpFile;
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Создает временную директорию.
     * @return Подготовленная директория.
     */
    protected File prepareDirectory() {
        try {
            File tmpDirectory = Files.createTempDirectory("2-epam-spring-2016").toFile();
            FILES.push(tmpDirectory);
            return tmpDirectory;
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Создает временную директорию для тестирования, копируя в него содержимое указанной директории.
     * @param name Имя копируемой директории.
     * @return Подготовленная директория.
     */
    protected File prepareDirectory(String name) {
        File tmpDirectory = prepareDirectory();
        this.copyDirectory(this.getResource(name), tmpDirectory);
        return tmpDirectory;
    }

    /**
     * Осуществляет копирование элементов из одной директории в другую.
     * @param from Исходная директория.
     * @param to Конечная директория.
     */
    private void copyDirectory(File from, File to) {
        try {
            File[] files = from.listFiles();
            if (files == null) {
                throw new IllegalArgumentException("File is not directory: " + from);
            }
            for (File file : files) {
                File copy = new File(to.getAbsolutePath() + File.separator + file.getName());
                FILES.push(copy);
                if (file.isDirectory()) {
                    if (!copy.mkdir()) {
                        throw new RuntimeException("Can't create directory: " + copy);
                    }
                    this.copyDirectory(file, copy);
                } else {
                    Files.copy(file.toPath(), copy.toPath());
                }
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * @param path Путь до файла, располагающегося в ресурсах для тестирования.
     * @return Дескриптор файла.
     */
    protected File getResource(String path) {
        ClassLoader classLoader = getClass().getClassLoader();
        URL url = classLoader.getResource(path);
        if (url == null) {
            throw new RuntimeException(new NoSuchFileException(path));
        }
        return new File(url.getFile());
    }

    /** Производит очистку ресурсов, удаляя созданные временные файлы. */
    @Override
    public void close() throws IOException {
        while (!FILES.isEmpty()) {
            if (!FILES.pop().delete()) {
                throw new IllegalStateException("Can't release file!");
            }
        }
    }
}
