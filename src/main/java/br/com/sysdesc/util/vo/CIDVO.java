package br.com.sysdesc.util.vo;

import java.io.File;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CIDVO {

    private File arquivo;

    private String cid;

}