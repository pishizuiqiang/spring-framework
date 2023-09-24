package org.springframework.core.convert.support;

import org.junit.Test;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.ConditionalGenericConverter;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

// 按两次 Shift 打开“随处搜索”对话框并输入 `show whitespaces`，
// 然后按 Enter 键。现在，您可以在代码中看到空格字符。
public class Main {
	public static void main(String[] args) {
		// 当文本光标位于高亮显示的文本处时按 Opt+Enter，
		// 可查看 IntelliJ IDEA 对于如何修正该问题的建议。
		System.out.printf("Hello and welcome!");

		// 按 Ctrl+R 或点击装订区域中的绿色箭头按钮以运行脚本。
		for (int i = 1; i <= 5; i++) {

			// 按 Ctrl+D 开始调试代码。我们已为您设置了一个断点，
			// 但您始终可以通过按 Cmd+F8 添加更多断点。
			System.out.println("i = " + i);
		}
	}


	/**
	 * 1 比 1 转换器
	 * Converter：1:1
	 */
	@Test
	public void converterTest() {
		System.out.println("----------------StringToBooleanConverter---------------");
		Converter<String, Boolean> converter = new StringToBooleanConverter();

		// trueValues.add("true");
		// trueValues.add("on");
		// trueValues.add("yes");
		// trueValues.add("1");
		System.out.println(converter.convert("true"));
		System.out.println(converter.convert("1"));

		// falseValues.add("false");
		// falseValues.add("off");
		// falseValues.add("no");
		// falseValues.add("0");
		System.out.println(converter.convert("FalSe"));
		System.out.println(converter.convert("off"));
		// 注意：空串返回的是null
		System.out.println(converter.convert(""));


		System.out.println("----------------StringToCharsetConverter---------------");
		Converter<String, Charset> converter2 = new StringToCharsetConverter();
		// 中间横杠非必须，但强烈建议写上   不区分大小写
		System.out.println(converter2.convert("uTf-8"));
		System.out.println(converter2.convert("utF8"));
	}


	/**
	 * 一对多
	 * 由一个 工厂根据类型生成多个 converter
	 * ConverterFactory：1:N
	 */
	@Test
	public void test2() {
		System.out.println("----------------StringToNumberConverterFactory---------------");
		ConverterFactory<String, Number> converterFactory = new StringToNumberConverterFactory();
		// 注意：这里不能写基本数据类型。如int.class将抛错
		System.out.println(converterFactory.getConverter(Integer.class).convert("1").getClass());
		System.out.println(converterFactory.getConverter(Double.class).convert("1.1").getClass());
		System.out.println(converterFactory.getConverter(Byte.class).convert("0x11").getClass());
	}


	@Test
	public void test3() {
		System.out.println("----------------CollectionToCollectionConverter---------------");
		ConditionalGenericConverter conditionalGenericConverter = new CollectionToCollectionConverter(new DefaultConversionService());
		// 将Collection转为Collection（注意：没有指定泛型类型哦）
		System.out.println(conditionalGenericConverter.getConvertibleTypes());

		List<String> sourceList = Arrays.asList("1", "2", "2", "3", "4");
		TypeDescriptor sourceTypeDesp = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(String.class));
		TypeDescriptor targetTypeDesp = TypeDescriptor.collection(Set.class, TypeDescriptor.valueOf(Integer.class));

		System.out.println(conditionalGenericConverter.matches(sourceTypeDesp, targetTypeDesp));
		Object convert = conditionalGenericConverter.convert(sourceList, sourceTypeDesp, targetTypeDesp);
		System.out.println(convert.getClass());
		System.out.println(convert);
	}
}