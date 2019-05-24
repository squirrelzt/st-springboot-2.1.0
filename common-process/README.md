QueryConvert实现类型转换

JsonResult<Person> jsonResult = JSON.parseObject(content, new TypeReference<JsonResult<Person>>(){});
JSON解析泛型