package br.com.sysdesc.util.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DimensionsVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int width;

	private int height;
}
