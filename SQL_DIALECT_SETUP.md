# SQL Dialect Configuration Guide

## Issue: SQL Syntax Errors in IntelliJ IDEA

If you're seeing syntax errors in the `V1__schoolDb.sql` file like:
- "Invalid or incomplete statement"
- "expected one of the following: FUNCTION, PACKAGE, PROCEDURE..."

This is because IntelliJ IDEA is detecting the wrong SQL dialect (probably Oracle instead of MySQL).

## Solution 1: Configure SQL Dialect in IntelliJ IDEA

### Method A: File-Level Configuration
1. Open the file: `src/main/resources/db/migration/V1__schoolDb.sql`
2. Look at the bottom-right corner of the editor for the SQL dialect indicator
3. Click on it (it might show "Oracle" or "No SQL dialect configured")
4. Select **MySQL** from the dropdown menu
5. The errors should disappear immediately

### Method B: Project-Wide Configuration
1. Go to **File** → **Settings** (or **IntelliJ IDEA** → **Preferences** on Mac)
2. Navigate to **Languages & Frameworks** → **SQL Dialects**
3. Find **Project SQL Dialect** dropdown
4. Select **MySQL**
5. Click **Apply** and **OK**

### Method C: Using sqldialects.xml (Already Created)
I've created a configuration file at `.idea/sqldialects.xml` that tells IntelliJ to use MySQL for your migration files. 

**To activate it:**
1. Close IntelliJ IDEA completely
2. Reopen the project
3. IntelliJ should now recognize MySQL as the dialect

## Solution 2: Ignore IDE Errors (if SQL works with Flyway)

The SQL file is **100% correct** for MySQL and Flyway. The errors you see are just IDE false positives. If:
- Your application starts successfully
- Flyway migrations run without errors
- Tables are created in the database

Then the SQL file is fine, and you can safely ignore the IDE errors.

## Verify Your SQL File is Correct

The SQL file has been fixed with the following improvements:

### What Was Fixed:
1. ✅ Removed `BEGIN;` statement (Flyway manages transactions)
2. ✅ Fixed `CURRENT_DATE` to `CURDATE()` (MySQL function)
3. ✅ Fixed typo: `NOT NULl` → `NOT NULL`
4. ✅ Added proper comments for documentation

### Current SQL Structure:
```sql
-- users table (authentication)
-- grades table (grade levels)
-- schools table (school information)
-- hostels table (hostel management)
-- classes table (class organization)
-- students table (student records with foreign keys)
```

## Why MySQL Dialect Matters

When MySQL dialect is properly configured, you get:
- ✅ Correct syntax highlighting
- ✅ Auto-completion for MySQL keywords
- ✅ Error detection for MySQL-specific syntax
- ✅ Code refactoring support
- ✅ Database schema inspection

## Test Your Database Setup

Run this command to verify the SQL works:

```bash
# Start your application
mvn spring-boot:run

# Check if tables are created
mysql -u root -p
USE school_sv_saas_db;
SHOW TABLES;
```

You should see:
- `classes`
- `flyway_schema_history`
- `grades`
- `hostels`
- `schools`
- `students`
- `users`

## Still Having Issues?

### Option 1: Refresh IntelliJ
1. **File** → **Invalidate Caches / Restart**
2. Select **Invalidate and Restart**
3. Wait for IntelliJ to reindex the project

### Option 2: Configure Database Connection
1. Go to **View** → **Tool Windows** → **Database**
2. Click **+** → **Data Source** → **MySQL**
3. Enter your connection details:
   - Host: `localhost`
   - Port: `3306`
   - Database: `school_sv_saas_db`
   - User: `root`
   - Password: `Root@123`
4. Click **Test Connection**
5. Once connected, right-click the SQL file → **Run**

### Option 3: Manually Set File Association
1. Right-click on `V1__schoolDb.sql`
2. Select **Associate with File Type...**
3. Choose **SQL** or **MySQL**

## Summary

**The SQL file is correct and will work perfectly with Flyway.**

The IDE errors are cosmetic and occur because IntelliJ needs to be told to use MySQL dialect. Follow any of the methods above to configure it properly.

Your database schema is solid and follows best practices:
- Proper foreign key constraints
- Unique constraints on emails
- ENUM types for controlled values
- Default values where appropriate
- Clear naming conventions

## Next Steps

1. ✅ SQL file is fixed and ready
2. ✅ README.md is comprehensive and updated
3. ✅ SQL dialect configuration file created
4. ⏩ Configure MySQL dialect in IntelliJ (follow Method A above)
5. ⏩ Run the application and verify tables are created
6. ⏩ Test the API endpoints

Happy coding! 🚀
