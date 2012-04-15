package hu.advancedweb.service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import hu.advancedweb.model.ExamAnswerClp;
import hu.advancedweb.model.ExamConfigClp;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ClpSerializer {
    private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
    private static ClassLoader _classLoader;
    private static String _servletContextName;

    public static String getServletContextName() {
        if (Validator.isNotNull(_servletContextName)) {
            return _servletContextName;
        }

        synchronized (ClpSerializer.class) {
            if (Validator.isNotNull(_servletContextName)) {
                return _servletContextName;
            }

            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Class<?> portletPropsClass = classLoader.loadClass(
                        "com.liferay.util.portlet.PortletProps");

                Method getMethod = portletPropsClass.getMethod("get",
                        new Class<?>[] { String.class });

                String portletPropsServletContextName = (String) getMethod.invoke(null,
                        "lms-portlet-deployment-context");

                if (Validator.isNotNull(portletPropsServletContextName)) {
                    _servletContextName = portletPropsServletContextName;
                }
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info(
                        "Unable to locate deployment context from portlet properties");
                }
            }

            if (Validator.isNull(_servletContextName)) {
                try {
                    String propsUtilServletContextName = PropsUtil.get(
                            "lms-portlet-deployment-context");

                    if (Validator.isNotNull(propsUtilServletContextName)) {
                        _servletContextName = propsUtilServletContextName;
                    }
                } catch (Throwable t) {
                    if (_log.isInfoEnabled()) {
                        _log.info(
                            "Unable to locate deployment context from portal properties");
                    }
                }
            }

            if (Validator.isNull(_servletContextName)) {
                _servletContextName = "lms-portlet";
            }

            return _servletContextName;
        }
    }

    public static void setClassLoader(ClassLoader classLoader) {
        _classLoader = classLoader;
    }

    public static Object translateInput(BaseModel<?> oldModel) {
        Class<?> oldModelClass = oldModel.getClass();

        String oldModelClassName = oldModelClass.getName();

        if (oldModelClassName.equals(ExamAnswerClp.class.getName())) {
            return translateInputExamAnswer(oldModel);
        }

        if (oldModelClassName.equals(ExamConfigClp.class.getName())) {
            return translateInputExamConfig(oldModel);
        }

        return oldModel;
    }

    public static Object translateInput(List<Object> oldList) {
        List<Object> newList = new ArrayList<Object>(oldList.size());

        for (int i = 0; i < oldList.size(); i++) {
            Object curObj = oldList.get(i);

            newList.add(translateInput(curObj));
        }

        return newList;
    }

    public static Object translateInputExamAnswer(BaseModel<?> oldModel) {
        ExamAnswerClp oldCplModel = (ExamAnswerClp) oldModel;

        Thread currentThread = Thread.currentThread();

        ClassLoader contextClassLoader = currentThread.getContextClassLoader();

        try {
            currentThread.setContextClassLoader(_classLoader);

            try {
                Class<?> newModelClass = Class.forName("hu.advancedweb.model.impl.ExamAnswerImpl",
                        true, _classLoader);

                Object newModel = newModelClass.newInstance();

                Method method0 = newModelClass.getMethod("setId",
                        new Class[] { Long.TYPE });

                Long value0 = new Long(oldCplModel.getId());

                method0.invoke(newModel, value0);

                Method method1 = newModelClass.getMethod("setGroupId",
                        new Class[] { Long.TYPE });

                Long value1 = new Long(oldCplModel.getGroupId());

                method1.invoke(newModel, value1);

                Method method2 = newModelClass.getMethod("setCompanyId",
                        new Class[] { Long.TYPE });

                Long value2 = new Long(oldCplModel.getCompanyId());

                method2.invoke(newModel, value2);

                Method method3 = newModelClass.getMethod("setUserId",
                        new Class[] { Long.TYPE });

                Long value3 = new Long(oldCplModel.getUserId());

                method3.invoke(newModel, value3);

                Method method4 = newModelClass.getMethod("setAnswers",
                        new Class[] { String.class });

                String value4 = oldCplModel.getAnswers();

                method4.invoke(newModel, value4);

                Method method5 = newModelClass.getMethod("setDate",
                        new Class[] { Date.class });

                Date value5 = oldCplModel.getDate();

                method5.invoke(newModel, value5);

                Method method6 = newModelClass.getMethod("setExamConfigId",
                        new Class[] { Long.TYPE });

                Long value6 = new Long(oldCplModel.getExamConfigId());

                method6.invoke(newModel, value6);

                return newModel;
            } catch (Exception e) {
                _log.error(e, e);
            }
        } finally {
            currentThread.setContextClassLoader(contextClassLoader);
        }

        return oldModel;
    }

    public static Object translateInputExamConfig(BaseModel<?> oldModel) {
        ExamConfigClp oldCplModel = (ExamConfigClp) oldModel;

        Thread currentThread = Thread.currentThread();

        ClassLoader contextClassLoader = currentThread.getContextClassLoader();

        try {
            currentThread.setContextClassLoader(_classLoader);

            try {
                Class<?> newModelClass = Class.forName("hu.advancedweb.model.impl.ExamConfigImpl",
                        true, _classLoader);

                Object newModel = newModelClass.newInstance();

                Method method0 = newModelClass.getMethod("setId",
                        new Class[] { Long.TYPE });

                Long value0 = new Long(oldCplModel.getId());

                method0.invoke(newModel, value0);

                Method method1 = newModelClass.getMethod("setGroupId",
                        new Class[] { Long.TYPE });

                Long value1 = new Long(oldCplModel.getGroupId());

                method1.invoke(newModel, value1);

                Method method2 = newModelClass.getMethod("setCompanyId",
                        new Class[] { Long.TYPE });

                Long value2 = new Long(oldCplModel.getCompanyId());

                method2.invoke(newModel, value2);

                Method method3 = newModelClass.getMethod("setQuestions",
                        new Class[] { String.class });

                String value3 = oldCplModel.getQuestions();

                method3.invoke(newModel, value3);

                Method method4 = newModelClass.getMethod("setEvaluator",
                        new Class[] { String.class });

                String value4 = oldCplModel.getEvaluator();

                method4.invoke(newModel, value4);

                return newModel;
            } catch (Exception e) {
                _log.error(e, e);
            }
        } finally {
            currentThread.setContextClassLoader(contextClassLoader);
        }

        return oldModel;
    }

    public static Object translateInput(Object obj) {
        if (obj instanceof BaseModel<?>) {
            return translateInput((BaseModel<?>) obj);
        } else if (obj instanceof List<?>) {
            return translateInput((List<Object>) obj);
        } else {
            return obj;
        }
    }

    public static Object translateOutput(BaseModel<?> oldModel) {
        Class<?> oldModelClass = oldModel.getClass();

        String oldModelClassName = oldModelClass.getName();

        if (oldModelClassName.equals("hu.advancedweb.model.impl.ExamAnswerImpl")) {
            return translateOutputExamAnswer(oldModel);
        }

        if (oldModelClassName.equals("hu.advancedweb.model.impl.ExamConfigImpl")) {
            return translateOutputExamConfig(oldModel);
        }

        return oldModel;
    }

    public static Object translateOutput(List<Object> oldList) {
        List<Object> newList = new ArrayList<Object>(oldList.size());

        for (int i = 0; i < oldList.size(); i++) {
            Object curObj = oldList.get(i);

            newList.add(translateOutput(curObj));
        }

        return newList;
    }

    public static Object translateOutput(Object obj) {
        if (obj instanceof BaseModel<?>) {
            return translateOutput((BaseModel<?>) obj);
        } else if (obj instanceof List<?>) {
            return translateOutput((List<Object>) obj);
        } else {
            return obj;
        }
    }

    public static Object translateOutputExamAnswer(BaseModel<?> oldModel) {
        Thread currentThread = Thread.currentThread();

        ClassLoader contextClassLoader = currentThread.getContextClassLoader();

        try {
            currentThread.setContextClassLoader(_classLoader);

            try {
                ExamAnswerClp newModel = new ExamAnswerClp();

                Class<?> oldModelClass = oldModel.getClass();

                Method method0 = oldModelClass.getMethod("getId");

                Long value0 = (Long) method0.invoke(oldModel, (Object[]) null);

                newModel.setId(value0);

                Method method1 = oldModelClass.getMethod("getGroupId");

                Long value1 = (Long) method1.invoke(oldModel, (Object[]) null);

                newModel.setGroupId(value1);

                Method method2 = oldModelClass.getMethod("getCompanyId");

                Long value2 = (Long) method2.invoke(oldModel, (Object[]) null);

                newModel.setCompanyId(value2);

                Method method3 = oldModelClass.getMethod("getUserId");

                Long value3 = (Long) method3.invoke(oldModel, (Object[]) null);

                newModel.setUserId(value3);

                Method method4 = oldModelClass.getMethod("getAnswers");

                String value4 = (String) method4.invoke(oldModel,
                        (Object[]) null);

                newModel.setAnswers(value4);

                Method method5 = oldModelClass.getMethod("getDate");

                Date value5 = (Date) method5.invoke(oldModel, (Object[]) null);

                newModel.setDate(value5);

                Method method6 = oldModelClass.getMethod("getExamConfigId");

                Long value6 = (Long) method6.invoke(oldModel, (Object[]) null);

                newModel.setExamConfigId(value6);

                return newModel;
            } catch (Exception e) {
                _log.error(e, e);
            }
        } finally {
            currentThread.setContextClassLoader(contextClassLoader);
        }

        return oldModel;
    }

    public static Object translateOutputExamConfig(BaseModel<?> oldModel) {
        Thread currentThread = Thread.currentThread();

        ClassLoader contextClassLoader = currentThread.getContextClassLoader();

        try {
            currentThread.setContextClassLoader(_classLoader);

            try {
                ExamConfigClp newModel = new ExamConfigClp();

                Class<?> oldModelClass = oldModel.getClass();

                Method method0 = oldModelClass.getMethod("getId");

                Long value0 = (Long) method0.invoke(oldModel, (Object[]) null);

                newModel.setId(value0);

                Method method1 = oldModelClass.getMethod("getGroupId");

                Long value1 = (Long) method1.invoke(oldModel, (Object[]) null);

                newModel.setGroupId(value1);

                Method method2 = oldModelClass.getMethod("getCompanyId");

                Long value2 = (Long) method2.invoke(oldModel, (Object[]) null);

                newModel.setCompanyId(value2);

                Method method3 = oldModelClass.getMethod("getQuestions");

                String value3 = (String) method3.invoke(oldModel,
                        (Object[]) null);

                newModel.setQuestions(value3);

                Method method4 = oldModelClass.getMethod("getEvaluator");

                String value4 = (String) method4.invoke(oldModel,
                        (Object[]) null);

                newModel.setEvaluator(value4);

                return newModel;
            } catch (Exception e) {
                _log.error(e, e);
            }
        } finally {
            currentThread.setContextClassLoader(contextClassLoader);
        }

        return oldModel;
    }
}
