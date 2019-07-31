package bcntec.training.mappers.modelmapper;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.Provider;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ModelMapperUtils {
    public static ModelMapper localDateTime2String(ModelMapper modelMapper, String pattern) {

        DateTimeFormatter format = DateTimeFormatter.ofPattern(pattern);
        Provider<LocalDateTime> localDateProvider = request -> LocalDateTime.now();
        Provider<String> stringProvider = request -> LocalDateTime.now().toString();


        Converter<String, LocalDateTime> stringToLocalDateTime = context -> {
            LocalDateTime localDate = LocalDateTime.parse(context.getSource(), format);
            return localDate;
        };
        Converter<LocalDateTime, String> localDateTimeToString = context -> {
            String string = format.format(context.getSource());
            return string;
        };


        modelMapper.createTypeMap(String.class, LocalDateTime.class).setProvider(localDateProvider);
        modelMapper.createTypeMap(LocalDateTime.class, String.class).setProvider(stringProvider);
        modelMapper.addConverter(stringToLocalDateTime);
        modelMapper.addConverter(localDateTimeToString);
        return modelMapper;
    }
}
