package com.schoolmanagement.demo.service;

import java.util.List;

import com.schoolmanagement.demo.entity.ClassName;
import com.schoolmanagement.demo.entity.Student;

public interface ClassService {
	 ClassName addClassName(ClassName className);
	    ClassName saveClass(ClassName className);
	    ClassName updateclass(ClassName className,Long id);
	    ClassName getClassById(Long id);
	    List<ClassName> getAllClassNames();
	    Boolean deleteClassNameById(Long id);

}
