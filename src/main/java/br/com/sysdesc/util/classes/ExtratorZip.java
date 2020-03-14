package br.com.sysdesc.util.classes;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import br.com.sysdesc.util.resources.Configuracoes;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExtratorZip {

    public void extrairVersao(File arquivoVersaoZIP) throws IOException {
        log.info("Extraindo arquivo {}", arquivoVersaoZIP);

        try (ZipInputStream zis = new ZipInputStream(new BufferedInputStream(new FileInputStream(arquivoVersaoZIP)))) {

            ZipEntry entry;

            while ((entry = zis.getNextEntry()) != null) {

                log.info("Extraindo: {}", entry.getName());

                if (entry.isDirectory()) {

                    new File(Configuracoes.USER_DIR + File.separator + entry.getName()).mkdirs();

                    continue;
                } else {

                    int di = entry.getName().lastIndexOf('/');

                    if (di != -1) {
                        new File(Configuracoes.USER_DIR + File.separator + entry.getName().substring(0, di)).mkdirs();
                    }
                }

                int count;

                byte[] data = new byte[1024];

                String arquivo = Configuracoes.USER_DIR + File.separator + entry.getName();

                try (FileOutputStream fos = new FileOutputStream(arquivo); BufferedOutputStream dest = new BufferedOutputStream(fos)) {

                    while ((count = zis.read(data)) != -1)
                        dest.write(data, 0, count);
                }
            }
        }

    }

}
