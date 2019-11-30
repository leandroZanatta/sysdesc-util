package br.com.sysdesc.util.classes;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import br.com.sysdesc.util.resources.Configuracoes;

public class ExtratorZip {

	public void extrairVersao(File arquivoVersaoZIP) throws Exception {

		BufferedOutputStream dest = null;

		try (ZipInputStream zis = new ZipInputStream(new BufferedInputStream(new FileInputStream(arquivoVersaoZIP)))) {

			ZipEntry entry;

			while ((entry = zis.getNextEntry()) != null) {

				System.out.println("Extraindo: " + entry.getName());

				if (entry.isDirectory()) {

					new File(Configuracoes.USER_DIR + "/" + entry.getName()).mkdirs();

					continue;
				} else {

					int di = entry.getName().lastIndexOf('/');

					if (di != -1) {
						new File(Configuracoes.USER_DIR + "/" + entry.getName().substring(0, di)).mkdirs();
					}
				}

				int count;

				byte data[] = new byte[1024];

				FileOutputStream fos = new FileOutputStream(Configuracoes.USER_DIR + "/" + entry.getName());

				dest = new BufferedOutputStream(fos);

				while ((count = zis.read(data)) != -1)
					dest.write(data, 0, count);

				dest.flush();

				dest.close();
			}
		}

	}

}
