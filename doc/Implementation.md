- Include a view with id <pre>actionbar_compat</pre> in your app.
- INclude a view with id <pre>actionbar_compat_text</pre> for the title.

# Subclassing BaseActivity

- Create your activity as a subclass of <pre>BaseAcitvity</pre>
- Call <pre>getActivityHelper().setupActionBar(null, 0);</pre> in your <pre>onCreate</pre> method.